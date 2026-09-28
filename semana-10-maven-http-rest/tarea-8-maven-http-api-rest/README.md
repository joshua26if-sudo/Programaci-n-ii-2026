# Actividad Maven, HTTP y REST - Control de Tareas

## Descripción del problema

Una aplicación necesita administrar las tareas pendientes de una persona. Cada tarea tiene un identificador, título, descripción, prioridad y estado de finalización.

## Tecnologías utilizadas

- Java 17
- Maven 3.9+
- JUnit 5 (para pruebas)

## Datos del proyecto Maven

- **groupId**: `com.estudiante`
- **artifactId**: `control-tareas`
- **version**: `1.0-SNAPSHOT`

### Explicación breve

- **groupId**: Identifica la organización o grupo al que pertenece el proyecto (ej: com.estudiante).
- **artifactId**: Nombre único del proyecto dentro del grupo (ej: control-tareas).
- **version**: Versión del proyecto. `1.0-SNAPSHOT` indica que está en desarrollo.

## Tabla de endpoints

| Operación                       | Método HTTP | Endpoint         | Respuesta esperada |
| ------------------------------- | ----------- | ---------------- | ------------------ |
| Consultar todas las tareas      | GET         | /api/tareas      | 200 OK             |
| Consultar una tarea             | GET         | /api/tareas/{id} | 200 OK             |
| Registrar una tarea             | POST        | /api/tareas      | 201 Created        |
| Modificar una tarea             | PUT         | /api/tareas/{id} | 200 OK             |
| Eliminar una tarea              | DELETE      | /api/tareas/{id} | 204 No Content     |
| Consultar una tarea inexistente | GET         | /api/tareas/{id} | 404 Not Found      |

## Instrucciones para compilar el proyecto

```bash
mvn clean
mvn compile
mvn test
mvn package
```

---

## Ejemplo de JSON

{
"id": 1,
"titulo": "Comprar alimentos",
"descripcion": "Comprar productos para la semana",
"prioridad": "ALTA",
"completada": false
}

## Estudiante

- **Nombre:** [Joshua-Israel-Flores-Pérez]
- **Carné:** [9941-25-9403]
