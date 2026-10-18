
CREATE TABLE libro (
	id BIGSERIAL PRIMARY KEY,
	codigo VARCHAR(20) NOT NULL UNIQUE,
	titulo VARCHAR(120) NOT NULL,
	autor VARCHAR(100) NOT NULL,
	categoria VARCHAR(50) NOT NULL,
	anio_publicacion INTEGER NOT NULL CHECK (anio_publicacion > 0),
	precio NUMERIC(8,2) NOT NULL CHECK (precio > 0),
	disponible BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO libro (codigo, titulo, autor, categoria, anio_publicacion, precio, disponible)
VALUES
	('LIB-001', 'El principito', 'Antoine de Saint-Exupery', 'Literatura', 1943, 85.50, TRUE),
	('LIB-002', 'Cien años de soledad', 'Gabriel García Márquez', 'Literatura', 1967, 120.00, TRUE),
	('LIB-003', 'Clean Code', 'Robert C. Martin', 'Programación', 2008, 250.00, FALSE);

SELECT codigo, titulo, autor, categoria, anio_publicacion, precio, disponible FROM libro;