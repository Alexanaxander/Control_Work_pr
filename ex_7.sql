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
SELECT * FROM Horses;


CREATE TABLE animals_3_years
WITH table_1 AS (SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pack_animals JOIN Horses ON Pack_animals.id = Horses.pack_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pack_animals JOIN Donkeys ON Pack_animals.id = Donkeys.pack_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pack_animals JOIN Camels ON Pack_animals.id = Camels.pack_id),
	table_2 AS (SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pets JOIN Cats ON Pets.id = Cats.pest_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pets JOIN Dogs ON Pets.id = Dogs.pest_id
		UNION ALL
		SELECT name_type, name_an, date_of_birth, executed_commands, breed, character_an 
		FROM Pets JOIN Hamsters ON Pets.id = Hamsters.pest_id),
	table_3 AS (SELECT * FROM table_1 UNION ALL SELECT * FROM table_2)
    
SELECT *, TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') AS 'Возраст(мес)' FROM table_3
where TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') >= 12 and TIMESTAMPDIFF(month, table_3.date_of_birth, '2024/03/27') <= 36;





CREATE TABLE animals_all
SELECT ANIMALS.id, ANIMALS.name_type, Pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Cats
LEFT JOIN Pets ON Pets.id = Cats.pest_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pets.animals_id
UNION
SELECT ANIMALS.id, ANIMALS.name_type, Pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Dogs
LEFT JOIN Pets ON Pets.id = Dogs.pest_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pets.animals_id
UNION
SELECT ANIMALS.id, ANIMALS.name_type, Pets.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Hamsters
LEFT JOIN Pets ON Pets.id = Hamsters.pest_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pets.animals_id
UNION
SELECT ANIMALS.id, ANIMALS.name_type, Pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Horses
LEFT JOIN Pack_animals ON Pack_animals.id = Horses.pack_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pack_animals.animals_id
UNION
SELECT ANIMALS.id, ANIMALS.name_type, Pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Donkeys
LEFT JOIN Pack_animals ON Pack_animals.id = Donkeys.pack_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pack_animals.animals_id
UNION
SELECT ANIMALS.id, ANIMALS.name_type, Pack_animals.name_type AS name_animal, name_an, date_of_birth, executed_commands, breed, character_an FROM Camels
LEFT JOIN Pack_animals ON Pack_animals.id = Camels.pack_id
LEFT JOIN ANIMALS ON ANIMALS.id = Pack_animals.animals_id
ORDER BY id;


