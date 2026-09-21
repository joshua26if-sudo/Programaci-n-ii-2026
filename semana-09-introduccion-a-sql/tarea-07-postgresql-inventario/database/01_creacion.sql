-- =====================================================
-- CREACIÓN DE LA TABLA PRODUCTO
-- =====================================================

DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
    id BIGSERIAL,
    codigo VARCHAR(15) NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    categoria VARCHAR(40) NOT NULL,
    precio NUMERIC(8,2) NOT NULL,
    stock INTEGER NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    
    CONSTRAINT pk_producto PRIMARY KEY (id),
    CONSTRAINT uk_producto_codigo UNIQUE (codigo),
    CONSTRAINT ck_producto_precio CHECK (precio > 0),
    CONSTRAINT ck_producto_stock CHECK (stock >= 0)
);

-- =====================================================
-- VERIFICACIÓN DE LA ESTRUCTURA
-- =====================================================


SELECT 
    conname AS nombre_restriccion,
    contype AS tipo,
    pg_get_constraintdef(oid) AS definicion
FROM pg_constraint
WHERE conrelid = 'producto'::regclass;