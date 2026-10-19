# Semana 13 - API Biblioteca Personal

## Nombre de la actividad

API REST para administrar los libros de una biblioteca personal con Spring Boot, Spring Data JPA y PostgreSQL.

## Descripción del problema

Se requiere desarrollar una API REST que permita gestionar la información de los libros de una biblioteca personal. La aplicación debe permitir registrar, consultar, actualizar y eliminar libros, guardando toda la información de forma persistente en una base de datos relacional PostgreSQL. No se permite el uso de listas en memoria como almacenamiento principal.

## Interfaz web

### Dirección para acceder

http://localhost:8080

## Tecnologías utilizadas

- **HTML5**
- **CSS personalizado + Bootstrap 5**
- **JavaScript (Fetch API)**
- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL Driver**
- **Maven**
- **PostgreSQL 14+**

### Funcionalidades disponibles

- Consultar todos los libros (GET)
- Registrar un nuevo libro (POST)
- Eliminar un libro existente (DELETE)
- Validaciones básicas del formulario
- Mensajes de éxito o error

## Estructura del proyecto

```text
semana-13-biblioteca-api/
├── database/
│   └── biblioteca.sql
├── evidencias/
│   └── Universidad Mariano Gálvez de Guatemala.docx
├── src/
│   └── main/
│       ├── java/
│       │   └── com/umg/tarea10arquitecturacapas/
│       │       ├── Tarea10ArquitecturaCapasApplication.java
│       │       ├── controller/
│       │       │   └── LibroController.java
│       │       ├── entity/
│       │       │   └── Libro.java
│       │       └── repository/
│       │           └── LibroRepository.java
│       └── resources/
│           └── application.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Configuración general de la base de datos

- Abrir pgAdmin o la consola de PostgreSQL.
- Crear la base de datos:
- CREATE DATABASE biblioteca_personal;
- Ejecutar el script ubicado en database/biblioteca.sql para crear la tabla libro y sus restricciones.
- Configurar las credenciales de conexión en el archivo src/main/resources/application.properties:
- spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_personal
- spring.datasource.username=postgres
- spring.datasource.password=TU_CONTRASENA

## Tabla de endpoints

| Operación                         | Método | Ruta                                | Estado esperado |
| --------------------------------- | ------ | ----------------------------------- | --------------- |
| Listar todos los libros           | GET    | `/api/libros`                       | 200             |
| Buscar un libro por ID            | GET    | `/api/libros/{id}`                  | 200 o 404       |
| Buscar por categoría              | GET    | `/api/libros/categoria/{categoria}` | 200             |
| Registrar un libro                | POST   | `/api/libros`                       | 201 Created     |
| Actualizar completamente un libro | PUT    | `/api/libros/{id}`                  | 200             |
| Eliminar un libro                 | DELETE | `/api/libros/{id}`                  | 204             |
| Listar libros disponibles         | GET    | `/api/libros/disponibles`           | 200             |

## Instrucciones para ejecutar

1. Asegúrate de que PostgreSQL esté corriendo y la base de datos `biblioteca_personal` exista.
2. Ejecuta la aplicación Spring Boot.
3. Abre en tu navegador: http://localhost:8080
4. Usa el formulario para registrar libros y la tabla para verlos/eliminarlos.

## Estudiante

- **Nombre completo:** Joshua-Israel-Flores-Pérez
- **Número de carné:** 9941-25-9403
- **Curso:** Programación II
