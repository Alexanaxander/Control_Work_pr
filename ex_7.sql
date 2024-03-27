DROP DATABASE IF EXISTS human_friends;

CREATE DATABASE human_friends;

USE human_friends;

CREATE TABLE IF NOT EXISTS ANIMALS (
	id int auto_increment primary key,
    name_type varchar(20)
);

INSERT INTO ANIMALS (name_type)
VALUES 	('Pets'), ('Pets'), ('Pets'), ('Pets'), ('Pets'), ('Pets'), ('Pack_animals'), 
('Pack_animals'), ('Pack_animals'), ('Pack_animals'), ('Pack_animals'), ('Pack_animals');

CREATE TABLE IF NOT EXISTS Pets (
	id int auto_increment primary key,
    name_type varchar(20),
    animals_id int,
    foreign key(animals_id) references ANIMALS(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Pets (name_type, animals_id)
VALUES 	('Собака', 1), ('Кошка', 2), ('Кот', 3), ('Хомяк', 4), ('Пес', 5), ('Хомяк', 6);

CREATE TABLE IF NOT EXISTS Pack_animals (
	id int auto_increment primary key,
    name_type varchar(20),
    animals_id int,
    foreign key(animals_id) references ANIMALS(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Pack_animals (name_type, animals_id)
VALUES 	('Верблюд', 7), ('Верблюд', 8), ('Конь', 9), ('Осел', 10), ('Ослиха', 11), ('Лошадь', 12);

CREATE TABLE IF NOT EXISTS Cats (
	id int auto_increment primary key,
    pest_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pest_id) references Pets(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Cats (pest_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(2, "Муся", "2022-06-15", "", "Дворняга", "Спокойный"), (3, "Барсик", "2024-01-10", "Дай лапу", "Вислоухий", "боязливый");


CREATE TABLE IF NOT EXISTS Dogs (
	id int auto_increment primary key,
    pest_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pest_id) references Pets(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Dogs (pest_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(1, "Лана", "2019-12-30", "Дай лапу, сидеть, рядом", "Немецкая овчарка", "Резвивый"), 
(5, "Бобик", "2015-10-10", "", "Дворняга", "Спокойный");

CREATE TABLE IF NOT EXISTS Hamsters (
	id int auto_increment primary key,
    pest_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pest_id) references Pets(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Hamsters (pest_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(4, "Кирил", "2023-11-05", "", "Джунгарский", "Резвивый"), 
(6, "Линда", "2023-07-24", "", "Сирийский хомяк", "Спокойный");

CREATE TABLE IF NOT EXISTS Horses (
	id int auto_increment primary key,
    pack_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pack_id) references Pack_animals(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Horses (pack_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(3, "Добрыня", "2014-10-05", "Вперд, стой", "Мустанг", "Резвивый"), 
(6, "Лана", "2021-03-14", "", "Орловский рысак", "Спокойный");

CREATE TABLE IF NOT EXISTS Camels (
	id int auto_increment primary key,
    pack_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pack_id) references Pack_animals(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Camels (pack_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(1, "Витя", "2015-10-05", "", "Двугорбый верблюд", "Резвивый"), 
(2, "Гектор", "2016-03-14", "", "Одногорбый верблюд", "Спокойный");

CREATE TABLE IF NOT EXISTS Donkeys (
	id int auto_increment primary key,
    pack_id int,
    name_an varchar(50),
    date_of_birth date,
    executed_commands varchar(250),
    breed varchar(50),
    character_an varchar(50),
    foreign key(pack_id) references Pack_animals(id)  ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Donkeys (pack_id, name_an, date_of_birth, executed_commands, breed, character_an)
VALUES 	(4, "Митя", "2017-07-22", "", "Пиренейская", "Резвивый"), 
(5, "Вера", "2016-12-01", "", "Котентен", "Спокойный");














DELETE FROM Camels WHERE id <> 0;

SELECT * FROM Donkeys
UNION ALL
SELECT * FROM HORSES;


CREATE TABLE animals_3_years
WITH table_1 AS (SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pack_animals JOIN horses ON pack_animals.id = horses.pack_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pack_animals JOIN Donkeys ON pack_animals.id = Donkeys.pack_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pack_animals JOIN Camels ON pack_animals.id = Camels.pack_id),
	table_2 AS (SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pets JOIN Cats ON pets.id = Cats.pest_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pets JOIN Dogs ON pets.id = Dogs.pest_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM pets JOIN Hamsters ON pets.id = Hamsters.pest_id),
	table_3 AS (SELECT * FROM table_1 UNION ALL SELECT * FROM table_2)
    
SELECT *, TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') AS 'Возраст(мес)' FROM table_3
where TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') >= 12 and TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') <= 36;





CREATE TABLE animals_all
SELECT animals.id, animals.name_type, pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Cats
LEFT JOIN pets ON pets.id = Cats.pest_id
LEFT JOIN animals ON animals.id = pets.animals_id
UNION
SELECT animals.id, animals.name_type, pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Dogs
LEFT JOIN pets ON pets.id = Dogs.pest_id
LEFT JOIN animals ON animals.id = pets.animals_id
UNION
SELECT animals.id, animals.name_type, pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM hamsters
LEFT JOIN pets ON pets.id = hamsters.pest_id
LEFT JOIN animals ON animals.id = pets.animals_id
UNION
SELECT animals.id, animals.name_type, pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM horses
LEFT JOIN pack_animals ON pack_animals.id = horses.pack_id
LEFT JOIN animals ON animals.id = pack_animals.animals_id
UNION
SELECT animals.id, animals.name_type, pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM donkeys
LEFT JOIN pack_animals ON pack_animals.id = donkeys.pack_id
LEFT JOIN animals ON animals.id = pack_animals.animals_id
UNION
SELECT animals.id, animals.name_type, pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM camels
LEFT JOIN pack_animals ON pack_animals.id = camels.pack_id
LEFT JOIN animals ON animals.id = pack_animals.animals_id
ORDER BY id;


