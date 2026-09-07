CREATE TABLE mascota (
	codigo VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	especie VARCHAR(30) NOT NULL,
	edad_meses INTEGER NOT NULL,
	peso_kg DECIMAL(5,2) NOT NULL,
	raza VARCHAR(50)
);

INSERT INTO mascota (codigo, nombre, especie, edad_meses, peso_kg, raza)
VALUES 
	('VET-001', 'Luna', 'Perro', 14, 12.5, 'Mestiza'),
	('VET-002', 'Milo', 'Gato', 24, 4.8, 'Siamés'),
	('VET-003', 'Piolín', 'Ave', 10, 0.4, 'Canario');

SELECT * FROM mascota;

UPDATE mascota SET peso_kg = 15.2 WHERE codigo = 'VET-001';

DELETE FROM mascota WHERE codigo = 'VET-003';

INSERT INTO mascota (codigo, nombre, especie, edad_meses, peso_kg, raza)
VALUES ('VET-001', 'Luna', 'Perro', 14, 12.5, 'Mestiza');