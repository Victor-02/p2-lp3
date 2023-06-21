CREATE TABLE Cachorro(
	id serial PRIMARY KEY,
	raca varchar(30),
	tamanho INT,
	idade INT
)

INSERT INTO Cachorro(id, raca, tamanho, idade) VALUES(1, 'caramelo', 1, 3)

SELECT * FROM Cachorro

DELETE FROM Cachorro