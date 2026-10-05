# API REST - Control de Despensa

## Nombre de la actividad

Desarrollo de una API REST básica para consultar y analizar productos almacenados en la despensa de un hogar.

## Descripción del problema

Se necesita una API REST que permita consultar y analizar los productos almacenados en la despensa de un hogar. Los datos permanecen en memoria y no se utiliza base de datos.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.5
- Maven
- Spring Web
- IntelliJ IDEA

## Requisitos para ejecutar el proyecto

- Java 17 o superior
- Maven 3.9+
- Puerto 8080 disponible

## Estructura principal

```
control-despensa-api/
├── src/main/java/com/estudiante/despensa/
│   ├── ControlDespensaApiApplication.java
│   ├── controller/ProductoController.java
│   └── model/
│       ├── Producto.java
│       └── ResumenInventario.java
├── src/main/resources/application.properties
├── pom.xml
└── README.md
```

## Explicación de las clases

- **Producto**: Representa un producto con id, nombre, categoría, cantidad y precio unitario. Incluye el método `calcularSubtotal()`.
- **ResumenInventario**: Representa el resumen general (cantidad de productos, total de unidades y valor total).
- **ProductoController**: Controlador REST que expone los seis endpoints.
- **ControlDespensaApiApplication**: Clase principal de Spring Boot.

## Tabla de endpoints

| Operación                         | Método | Ruta                                   | Estado esperado |
| --------------------------------- | ------ | -------------------------------------- | --------------- |
| Listar productos                  | GET    | `/api/productos`                       | 200             |
| Buscar por identificador          | GET    | `/api/productos/{id}`                  | 200 o 404       |
| Buscar por categoría              | GET    | `/api/productos/categoria/{categoria}` | 200             |
| Consultar stock bajo              | GET    | `/api/productos/stock-bajo`            | 200             |
| Consultar producto de mayor valor | GET    | `/api/productos/mayor-valor`           | 200             |
| Obtener resumen                   | GET    | `/api/productos/resumen`               | 200             |

## Instrucciones para ejecutar la aplicación

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `ControlDespensaApiApplication`.
3. La aplicación iniciará en `http://localhost:8080`.
4. Probar los endpoints en el navegador o Postman.

## Ejemplos de respuestas JSON

### GET /api/productos

```json
[
  {
    "id": 1,
    "nombre": "Leche",
    "categoria": "Lácteos",
    "cantidad": 2,
    "precioUnitario": 12.5
  },
  {
    "id": 2,
    "nombre": "Arroz",
    "categoria": "Granos",
    "cantidad": 4,
    "precioUnitario": 8.5
  }
]
```

### GET /api/productos/1

```json
{
  "id": 1,
  "nombre": "Leche",
  "categoria": "Lácteos",
  "cantidad": 2,
  "precioUnitario": 12.5
}
```

### GET /api/productos/resumen

```json
{ "cantidadProductos": 6, "totalUnidades": 28, "valorTotal": 320.5 }
```

## Estudiante

- **Nombre completo:** Joshua-Israel-Flores-Pérez
- **Número de carné:** 9941-25-9403
- **Curso:** Programación II
