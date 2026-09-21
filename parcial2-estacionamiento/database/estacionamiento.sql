-- =====================================================
-- Base de datos: parcial2_estacionamiento
-- Tabla: vehiculo
-- Parcial II - Sistema de Estacionamiento
-- =====================================================

-- Crear la tabla vehiculo
CREATE TABLE vehiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(15) NOT NULL UNIQUE,
    propietario VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    hora_ingreso TIME NOT NULL,
    horas_utilizadas INT NOT NULL CHECK (horas_utilizadas > 0),
    costo DECIMAL(10, 2) NOT NULL CHECK (costo >= 0),
    activo BOOLEAN DEFAULT TRUE,
    CONSTRAINT chk_tipo CHECK (tipo IN ('Automóvil', 'Motocicleta'))
);

-- =====================================================
-- INSERCIÓN DE REGISTROS (mínimo 5)
-- =====================================================

INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo) VALUES
('ABC123', 'Andrea López', 'Automóvil', '08:30', 3, 30.00),
('XYZ789', 'Carlos Pérez', 'Motocicleta', '09:15', 2, 12.00),
('DEF456', 'María Gómez', 'Automóvil', '10:00', 6, 54.00),
('GHI789', 'Juan Rodríguez', 'Motocicleta', '11:30', 8, 43.20),
('JKL012', 'Ana Martínez', 'Automóvil', '12:45', 4, 40.00);

-- =====================================================
-- CONSULTAS REQUERIDAS
-- =====================================================

-- 1. Consulta general seleccionando explícitamente las columnas
SELECT id, placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo, activo
FROM vehiculo;

-- 2. Consulta filtrada por tipo de vehículo
SELECT placa, propietario, tipo, costo
FROM vehiculo
WHERE tipo = 'Automóvil';

-- 3. Consulta de vehículos cuyo costo sea superior a un valor determinado
SELECT placa, propietario, tipo, costo
FROM vehiculo
WHERE costo > 30.00;

-- 4. Consulta ordenada por costo de mayor a menor
SELECT placa, propietario, tipo, costo
FROM vehiculo
ORDER BY costo DESC;

-- =====================================================
-- ACTUALIZACIONES
-- =====================================================

-- 5. Actualización de un registro
UPDATE vehiculo
SET costo = 35.00
WHERE placa = 'ABC123';

-- 6. Cambio de estado de un vehículo (activo = false)
UPDATE vehiculo
SET activo = FALSE
WHERE placa = 'XYZ789';

-- =====================================================
-- ELIMINACIÓN
-- =====================================================

-- 7. Eliminación de un registro
DELETE FROM vehiculo
WHERE placa = 'JKL012';

-- =====================================================
-- PRUEBAS DE RESTRICCIONES (ejecutar para verificar errores)
-- =====================================================

-- PRUEBA 1: Placa duplicada (debe dar error)
INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo) 
VALUES ('ABC123', 'Otro Propietario', 'Automóvil', '14:00', 2, 20.00);

-- PRUEBA 2: Horas inválidas (debe dar error)
INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo) 
VALUES ('MNO345', 'Pedro López', 'Automóvil', '15:00', -3, 30.00);

-- PRUEBA 3: Costo negativo (debe dar error)
INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo) 
VALUES ('PQR678', 'Luisa Fernández', 'Motocicleta', '16:00', 3, -18.00);