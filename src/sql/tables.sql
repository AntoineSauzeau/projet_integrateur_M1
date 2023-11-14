DROP TABLE IF EXIST Clients;
DROP TABLE IF EXIST Subscriber;
DROP TABLE IF EXIST NonSubscriber;
DROP TABLE IF EXIST Movies;
DROP TABLE IF EXIST Rents;
--DROP VIEW IF EXIST Rents;


CREATE table Clients(
    idClient int not null auto_increment,
    creditCard int not null,
    primary key (idClient),
);

CREATE table Subscribers(
    name varchar(50) not null,
    idClient int not null,
    primary key (idClient),
    foreign key (idClient) references LesClients(idClient)
);

CREATE table NonSubscribers(
    name varchar(50) not null,
    primary key (idClient),
    foreign key (idClient) references LesClients(idClient)
);

CREATE table Movies(
    movieID int not null auto_increment,
    movieName varchar(50) not null,
    directorName varchar(50) not null,
    actorsName varchar(50) not null,
    summary varchar(300) not null,
    primary key (idFilm)
);

CREATE table Rents(
    rentID int not null auto_increment,
    clientID int not null,
    movieID int not null,
    withdrawalDate date not null,
    returnDate date not null,
    primary key (idLocation),
    foreign key (idClient) references LesClients(idClient),
    foreign key (idFilm) references LesFilms(idFilm)
);



CREATE table Available(
    movieID int not null,
    quantity int not null,
    machineID int not null
    primary key (machineID,movieID)
    foreign key (movieID) references Movies(movieID)
    foreign key (machineID) references AL2000(machineID)
);

CREATE table AL2000(
    machineID int not null auto_increment,
    machineName varchar(50) not null,
    location varchar(50) not null,
    primary key (machineID)
);

-- CREATE view RentView as(
--     Select Rents.rentID, Clients.name, Movies.movieName, Rents.withdrawalDate, Rents.returnDate
--     from Rents join Clients on Rents.clientID = Clients.idClient
--     join Movies on Rents.movieID = Movies.movieID

-- );

