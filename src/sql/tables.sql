DROP TABLE IF EXISTS Subscribers;
DROP TABLE IF EXISTS NonSubscribers;
DROP TABLE IF EXISTS Movies;
DROP TABLE IF EXISTS Rents;
DROP TABLE IF EXISTS Available;
DROP TABLE IF EXISTS AL2000;
DROP TABLE IF EXISTS Actors;
DROP TABLE IF EXISTS MovieActors;
DROP TABLE IF EXISTS Reservations;
DROP TABLE IF EXISTS Clients;



CREATE TABLE Clients(
    clientID integer PRIMARY key autoincrement,
    creditCard int not null,
    check (creditCard >= 0)
);

CREATE table Subscribers(
    name varchar(50) not null,
    clientID int not null,
    address varchar(50) not null,
    birthDate date not null,
    mail varchar(50) not null,
    balance float not null, -- Contrainte appli arrondi à 2 chiffres après la virgule
    subCardID int not null,
    primary key (clientID),
    foreign key (clientID) references Clients(clientID) ON DELETE CASCADE
);

CREATE table NonSubscribers(
    clientID int not null,
    creditCard int not null,
    primary key (clientID),
    foreign key (clientID) references Clients(clientID) ON DELETE CASCADE
);  

CREATE table Movies(
    movieID integer PRIMARY key autoincrement,
    movieName varchar(50) not null,
    directorName varchar(50) not null,
    summary varchar(300) not null
);


CREATE table Rents(
    rentID integer primary key autoincrement,
    clientID int not null,
    movieID int not null,
    withdrawalDate date not null,
    paid boolean not null,
    type int not null,
    returnDate date, -- null si pas encore rendu
    foreign key (clientID) references Clients(clientID),
    foreign key (movieID) references Movies(movieID)
);



CREATE table Available(
    movieID int not null,
    machineID int not null,
    quantity int not null,
    primary key (machineID,movieID),
    foreign key (movieID) references Movies(movieID),
    foreign key (machineID) references AL2000(machineID),
    check (quantity >= 0)
    -- Trigger pour somme totale < 100
);

CREATE table AL2000(
    machineID integer PRIMARY key autoincrement,
    machineName varchar(50) not null,
    location varchar(50) not null
);

CREATE table Actors (
    actorID integer primary key autoincrement,
    actorName varchar(50) not null
);


CREATE table MovieActors(
    movieID int not null,
    actorID int not null,
    primary key (movieID,actorID)
    foreign key (movieID) references Movies(movieID)
    foreign key (actorID) references Actors(actorID)
);

CREATE TABLE Reservations(
    machineID int not null,
    movieID int not null,
    reservationDate date not null,
    primary key (machineID,movieID,reservationDate),
    foreign key (machineID,movieID) references Available(machineID,movieID)
);





-- Trigger : Un client subscriber ne peut louer que 3 films en même temps et 1 film pour les non subscriber
CREATE OR REPLACE TRIGGER checkRent BEFORE INSERT ON Rents
FOR EACH ROW
BEGIN
    IF (SELECT status FROM Subscribers WHERE clientID = NEW.clientID) = 'Active' THEN
        IF (SELECT COUNT(*) FROM Rents WHERE clientID = NEW.clientID) >= 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can''t rent more than 3 movies at the same time';
        END IF;
    ELSE
        IF (SELECT COUNT(*) FROM Rents WHERE clientID = NEW.clientID) >= 1 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can''t rent more than 1 movie at the same time';
        END IF;
    END IF;
END;

-- Trigger : L’insertion, la mise à jour et la suppression dans la table Availability doivent respecter la contrainte que la somme des films disponibles dans chaque machine ne doit pas dépasser sa quantité maximale
CREATE OR REPLACE TRIGGER checkAvailable BEFORE INSERT OR UPDATE ON Available
FOR EACH ROW
BEGIN
    IF (SELECT SUM(quantity) FROM Available WHERE machineID = NEW.machineID) + NEW.quantity > 100 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The sum of the quantity of movies available in the machine can''t be more than 100';
    END IF;
END;

-- Trigger : La mise à jour du solde d’un abonné vérifie que le solde est positif, sinon carte gelée.
CREATE OR REPLACE  TRIGGER checkBalance BEFORE UPDATE ON Subscribers
FOR EACH ROW
BEGIN
    IF NEW.balance < 0 THEN
        SET NEW.status = 'Frozen';
    END IF;
END;

-- Trigger : L’insertion dans la table Reservation vérifie que le film souhaité n’est pas déjà dans les films en stock dans la machine.
CREATE OR REPLACE TRIGGER checkReservation BEFORE INSERT ON Reservation
FOR EACH ROW
BEGIN
    IF (SELECT COUNT(*) FROM Available WHERE machineID = NEW.machineID AND movieID = NEW.movieID) != 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The movie you want to reserve is available in this machine';
    END IF;
END;

-- Trigger : L’insertion dans Avaibility va regarder si le film ajouté est présent dans la table Réservation et supprimer la réservation le cas échéant.
CREATE OR REPLACE TRIGGER checkReservation BEFORE INSERT ON Available
FOR EACH ROW
BEGIN
    IF (SELECT COUNT(*) FROM Reservation WHERE machineID = NEW.machineID AND movieID = NEW.movieID) != 0 THEN
        DELETE FROM Reservation WHERE machineID = NEW.machineID AND movieID = NEW.movieID;
    END IF;
END;