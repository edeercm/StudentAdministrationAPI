# HELP.md

## Descripción del Proyecto

Esta es una aplicación simple construida con **Spring Boot** que expone una **API RESTful** para gestionar una lista de estudiantes. Está diseñada para fines educativos y prácticos, y cubre operaciones básicas **CRUD** (Crear, Leer, Actualizar y Eliminar) utilizando **Spring Web**, **Spring Data JPA** y una base de datos en memoria **H2**.

---

## Funcionalidades Implementadas

- Crear nuevos estudiantes (POST)
- Obtener lista de todos los estudiantes (GET)
- Actualizar información de un estudiante (PUT)
- Eliminar un estudiante (DELETE)

---

## Tecnologías Utilizadas

- **Spring Boot 3.4.5**
- **Java 21**
- **Spring Web**
- **Spring Data JPA**
- **Base de datos H2 (en memoria)**
- **Maven**
- **IDE: Visual Studio Code**

---

## Estructura del Proyecto

- `Student.java`: Entidad JPA que representa a un estudiante con campos `id`, `name`, `email` y `age`.
- `StudentRepository.java`: Interfaz que extiende `JpaRepository` para manejar operaciones de base de datos automáticamente.
- `StudentController.java`: Clase REST Controller que define los endpoints `/api/students`.
- `application.properties`: Archivo de configuración para habilitar la base de datos H2 y otras propiedades.

---

## Endpoints Disponibles

| Método | Endpoint               | Descripción                         |
|--------|------------------------|-------------------------------------|
| GET    | `/api/students`        | Obtener todos los estudiantes       |
| POST   | `/api/students`        | Crear un nuevo estudiante           |
| PUT    | `/api/students/{id}`   | Actualizar datos de un estudiante   |
| DELETE | `/api/students/{id}`   | Eliminar un estudiante por su ID    |

---

## Cómo Probar la API

Puedes usar **Postman** o cualquier cliente HTTP para probar los endpoints. La app corre por defecto en:  
`http://localhost:8080`

También puedes acceder a la consola de H2 Database desde:  
`http://localhost:8080/h2-console`

JDBC URL: `jdbc:h2:mem:studentdb`  
User: `sa`  
Password: *(vacío)*

---

## Notas Finales

Este proyecto es ideal como base para integrar con un frontend en **React**, usando herramientas como **React Hook Form** y **Axios** para hacer peticiones a la API.

