-- =====================================================
-- DATOS DE PRUEBA (MÍNIMO 8 PRODUCTOS)
-- =====================================================

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P001', 'Arroz Blanco 5lb', 'Granos', 25.50, 50),
('P002', 'Frijol Negro 5lb', 'Granos', 32.00, 3),
('P003', 'Leche Entera 1L', 'Lácteos', 12.75, 40),
('P004', 'Queso Fresco 1lb', 'Lácteos', 28.00, 15),
('P005', 'Pan Francés', 'Panadería', 1.50, 0),
('P006', 'Galletas de Chocolate', 'Panadería', 8.90, 25),
('P007', 'Aceite Vegetal 1L', 'Abarrotes', 18.50, 2),
('P008', 'Azúcar Blanca 2lb', 'Abarrotes', 15.00, 30);

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P009', 'Sal Refinada 1lb', 'Condimentos', 3.50, 45);

-- =====================================================
-- PRODUCTO TEMPORAL PARA PRUEBA DE ELIMINACIÓN
-- =====================================================

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('TEMP-001', 'Producto Temporal', 'Prueba', 1.00, 1);

-- =====================================================
-- PARTE 6: COMPROBACIÓN DE RESTRICCIONES
-- =====================================================

-- -------------------------------------
-- PRUEBA 1: CÓDIGO DUPLICADO
-- -------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P001', 'Producto Duplicado', 'Prueba', 10.00, 5);

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P010', 'Producto Corregido', 'Prueba', 10.00, 5);

-- -------------------------------------
-- PRUEBA 2: STOCK NEGATIVO
-- -------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P011', 'Stock Negativo', 'Prueba', 10.00, -5);

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P011', 'Stock Corregido', 'Prueba', 10.00, 5);

-- -------------------------------------
-- PRUEBA 3: PRECIO INVÁLIDO
-- -------------------------------------
INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P012', 'Precio Inválido', 'Prueba', 0, 5);

INSERT INTO producto (codigo, nombre, categoria, precio, stock) VALUES
('P012', 'Precio Corregido', 'Prueba', 5.00, 5);

-- =====================================================
-- VERIFICACIÓN DE DATOS INSERTADOS
-- =====================================================

SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
ORDER BY id;

SELECT COUNT(*) AS total_productos FROM producto;