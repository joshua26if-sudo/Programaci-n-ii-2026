-- =====================================================
-- PARTE 4: CONSULTAS OBLIGATORIAS
-- =====================================================

-- -------------------------------------
-- CONSULTA 1: Mostrar código, nombre, categoría, precio y stock de todos los productos
-- -------------------------------------
SELECT codigo, nombre, categoria, precio, stock
FROM producto
ORDER BY codigo;
	
-- -------------------------------------
-- CONSULTA 2: Buscar productos de una categoría específica
-- -------------------------------------
SELECT codigo, nombre, categoria, precio, stock
FROM producto
WHERE categoria = 'Lácteos';

-- -------------------------------------
-- CONSULTA 3: Productos ordenados del precio más alto al más bajo
-- -------------------------------------
SELECT codigo, nombre, categoria, precio
FROM producto
ORDER BY precio DESC;

-- -------------------------------------
-- CONSULTA 4: Productos con tres unidades o menos
-- -------------------------------------
SELECT codigo, nombre, categoria, stock
FROM producto
WHERE stock <= 3;

-- -------------------------------------
-- CONSULTA 5: Productos activos con existencias
-- -------------------------------------
SELECT codigo, nombre, categoria, stock, activo
FROM producto
WHERE activo = TRUE AND stock > 0;

-- -------------------------------------
-- CONSULTA 6: Buscar un producto por su código
-- -------------------------------------
SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'P003';

-- =====================================================
-- PARTE 5: ACTUALIZACIONES Y ELIMINACIÓN
-- =====================================================

-- -------------------------------------
-- SIMULACIÓN DE VENTA
-- -------------------------------------

SELECT codigo, nombre, stock AS stock_antes
FROM producto
WHERE codigo = 'P001';

UPDATE producto
SET stock = stock - 2
WHERE codigo = 'P001';

SELECT codigo, nombre, stock AS stock_despues
FROM producto
WHERE codigo = 'P001';

-- -------------------------------------
-- PRODUCTOS AGOTADOS
-- -------------------------------------
SELECT codigo, nombre, stock, activo
FROM producto
WHERE stock = 0;

UPDATE producto
SET activo = FALSE
WHERE stock = 0;

SELECT codigo, nombre, stock, activo
FROM producto
WHERE activo = FALSE;

-- -------------------------------------
-- ELIMINACIÓN DEL PRODUCTO TEMPORAL
-- -------------------------------------
SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';

DELETE FROM producto
WHERE codigo = 'TEMP-001';

SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
WHERE codigo = 'TEMP-001';

-- =====================================================
-- CONSULTAS FINALES DE VERIFICACIÓN
-- =====================================================

SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto
ORDER BY id;

SELECT categoria, COUNT(*) AS cantidad, SUM(stock) AS stock_total
FROM producto
GROUP BY categoria
ORDER BY categoria;

SELECT codigo, nombre, categoria, stock
FROM producto
WHERE activo = TRUE AND stock <= 3
ORDER BY stock;