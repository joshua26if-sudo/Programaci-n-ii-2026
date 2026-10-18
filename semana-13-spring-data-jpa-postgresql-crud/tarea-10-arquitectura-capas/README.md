# Semana 13 - API Biblioteca Personal

## Nombre de la actividad

API REST para administrar los libros de una biblioteca personal con Spring Boot, Spring Data JPA y PostgreSQL.

## Descripción del problema

Se requiere desarrollar una API REST que permita gestionar la información de los libros de una biblioteca personal. La aplicación debe permitir registrar, consultar, actualizar y eliminar libros, guardando toda la información de forma persistente en una base de datos relacional PostgreSQL. No se permite el uso de listas en memoria como almacenamiento principal.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Web** (para los endpoints REST)
- **Spring Data JPA** (para la persistencia)
- **PostgreSQL Driver** (conexión a la base de datos)
- **Maven** (gestor de dependencias)
- **PostgreSQL 14+** (base de datos)

## Estructura del proyecto

```text
semana-13-biblioteca-api/
├── database/
│   └── biblioteca.sql
├── evidencias/
│   └── Evidencias_Biblioteca_NombreApellido.docx
├── src/
│   └── main/
│       ├── java/
│       │   └── com/estudiante/biblioteca/
│       │       ├── BibliotecaApiApplication.java
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

## Instrucciones para ejecutar la aplicación

1. Clonar este repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Asegurarse de tener PostgreSQL ejecutándose y la base de datos biblioteca_personal creada.
4. Configurar la contraseña de PostgreSQL en application.properties.
5. Ejecutar la clase BibliotecaApiApplication.
6. La aplicación estará disponible en http://localhost:8080.
7. Probar los endpoints utilizando Postman o un navegador web.

## Estudiante

- **Nombre completo:** Joshua-Israel-Flores-Pérez
- **Número de carné:** 9941-25-9403
- **Curso:** Programación II
