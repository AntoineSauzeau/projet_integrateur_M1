-- Insertion des clients fictifs
INSERT INTO Clients (creditCard) VALUES
(1234567890123456),
(9876543210987654),
(1111222233334444);

-- Insertion des abonnés fictifs
INSERT INTO Subscribers (name, clientID, address, birthDate, mail, balance, subCardID) VALUES
('John Doe', 1, '123 Main St', '1990-01-15', 'john.doe@email.com', 50.00, 12345),
('Alice Smith', 2, '456 Oak St', '1985-05-20', 'alice.smith@email.com', 75.50, 67890);

-- Insertion des non-abonnés fictifs
INSERT INTO NonSubscribers (clientID, creditCard) VALUES
(3, 5555666677778888);

-- Insertion des films fictifs
INSERT INTO Movies (movieName, directorName, summary) VALUES
('Interstellar', 'Christopher Nolan', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.');

-- Insertion des locations de films fictives
INSERT INTO Rents (clientID, movieID, withdrawalDate, paid, type, returnDate) VALUES
(1, 1, '2023-01-01', TRUE, 0, '2023-01-10'),
(2, 1, '2023-02-01', TRUE, 1, '2023-02-15');

-- Insertion des acteurs fictifs
INSERT INTO Actors (actorName) VALUES
('Matthew McConaughey'),
('Anne Hathaway'),
('Jessica Chastain');

-- Insertion des associations entre films et acteurs fictives
INSERT INTO MovieActors (movieID, actorID) VALUES
(1, 1),
(1, 2),
(1, 3);

-- Insertion de films fictifs
INSERT INTO Movies (movieName, directorName, summary) VALUES
('The Matrix', 'Lana Wachowski', 'A computer hacker learns about the true nature of his reality and his role in the war against its controllers.'),
('Inception', 'Christopher Nolan', 'A thief who enters the dreams of others to steal their secrets faces a new challenge when tasked with planting an idea into someone''s mind.'),
('Pulp Fiction', 'Quentin Tarantino', 'Various interconnected stories of criminals in Los Angeles.'),
('The Shawshank Redemption', 'Frank Darabont', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.'),
('The Dark Knight', 'Christopher Nolan', 'When the menace known as The Joker emerges, Batman must confront him and bring justice to Gotham City.'),
('Forrest Gump', 'Robert Zemeckis', 'The life journey of Forrest Gump, a man with a low I.Q. but good intentions.'),
('The Godfather', 'Francis Ford Coppola', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
('Star Wars: Episode IV - A New Hope', 'George Lucas', 'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee, and two droids to save the galaxy from the Empire''s world-destroying battle station.'),
('Titanic', 'James Cameron', 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.');

-- Ajout des acteurs fictifs
INSERT INTO Actors (actorName) VALUES
('Keanu Reeves'),
('Laurence Fishburne'),
('Carrie-Anne Moss'),
('Joseph Gordon-Levitt'),
('Ellen Page'),
('John Travolta'),
('Uma Thurman'),
('Samuel L. Jackson'),
('Tim Robbins'),
('Morgan Freeman'),
('Bob Gunton'),
('Christian Bale'),
('Heath Ledger'),
('Aaron Eckhart'),
('Tom Hanks'),
('Robin Wright'),
('Gary Sinise'),
('Marlon Brando'),
('Al Pacino'),
('James Caan'),
('Mark Hamill'),
('Harrison Ford'),
('Carrie Fisher'),
('Kate Winslet'),
('Billy Zane');

-- Ajout des associations entre films et acteurs fictifs
-- Vous devrez ajuster les valeurs des ID de film et d'acteur en fonction de vos données réelles
INSERT INTO MovieActors (movieID, actorID) VALUES
(2, 1),
(2, 2),
(2, 3),
(3, 6),
(3, 7),
(3, 8),
(4, 9),
(4, 10),
(4, 11),
(5, 12),
(5, 13),
(5, 14),
(6, 15),
(6, 16),
(6, 17),
(7, 18),
(7, 19),
(7, 20),
(8, 21),
(8, 22),
(8, 23),
(9, 24),
(9, 25),
(9, 26);

-- Ajout des locations de films fictives
INSERT INTO Rents (clientID, movieID, withdrawalDate, paid, type, returnDate) VALUES
(1, 2, '2023-03-01', TRUE,0, '2023-03-10'),
(2, 3, '2023-04-01', TRUE,0, '2023-04-15'),
(3, 4, '2023-05-01', TRUE,1, '2023-05-10');