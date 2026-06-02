# Student Administration API

API REST educativa para gestionar estudiantes. Código limpio, fácil de extender, pensado para aprendizaje, demos y experimentos con IA.

> ⚠️ Nota: README anterior contenía descripciones duplicadas y comandos incorrectos para Windows. Esta versión unifica y corrige.

---

## 📌 Descripción

Microservicio simple en **Spring Boot** que expone endpoints REST **CRUD** para la entidad `Student`. Ideal para demos, pruebas de integración y como base para añadir validaciones, seguridad y capas de negocio.

---

## ✨ Características

- CRUD completo sobre `Student` (Create, Read, Update, Delete)
- Persistencia con **Spring Data JPA**
- Base de datos en memoria **H2** para pruebas rápidas
- Endpoints JSON, listas y operaciones por `id`

---

## 🛠 Tecnologías

- Spring Boot 3.4.5
- Java 21
- Spring Web
- Spring Data JPA
- H2 (in-memory)
- Maven (wrapper incluido)

---

## 📂 Estructura del repositorio

- `src/main/java/com/example/student_api/` — Código fuente
  - `StudentApiApplication.java` — Punto de entrada Spring Boot
  - `controller/StudentController.java` — Endpoints REST en `/api/students`
  - `model/Student.java` — Entidad JPA (`id`, `name`, `email`, `age`)
  - `repository/StudentRepository.java` — Extiende `JpaRepository<Student, Long>`
- `src/main/resources/application.properties` — Configuración (H2, JPA, puerto)
- `pom.xml` — Dependencias y plugin Spring Boot

> ⚠️ Verifica el paquete real en el repositorio (puede diferir).

---

## 📋 Requisitos previos

- **Java 21** instalado (o JDK compatible)
- **Maven** (opcional si usa `mvnw` / `mvnw.cmd`)

---

## ▶️ Construir y ejecutar

### Windows (usar wrapper incluido)

```powershell
.\mvnw.cmd package
.\mvnw.cmd spring-boot:run
```

### Unix/macOS

```bash
./mvnw package
./mvnw spring-boot:run
```

La app se ejecuta por defecto en: **http://localhost:8080**

---

## 🔌 Endpoints (ejemplos)

### Obtener todos los estudiantes

```bash
curl -s http://localhost:8080/api/students
```

### Crear estudiante

```bash
curl -s -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"Ana","email":"ana@example.com","age":21}'
```

### Actualizar estudiante

```bash
curl -s -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Ana Perez","email":"ana.perez@example.com","age":22}'
```

### Eliminar estudiante

```bash
curl -s -X DELETE http://localhost:8080/api/students/1
```

---

## 🧠 Modelo de datos

Entidad `Student` campos:

| Campo   | Tipo  | Descripción                   |
|---------|-------|-------------------------------|
| `id`    | Long  | PK, autogenerado              |
| `name`  | String| Nombre del estudiante         |
| `email` | String| Email (único recomendable)    |
| `age`   | int   | Edad del estudiante           |

---

## 💾 Persistencia y configuración

- H2 en memoria: `jdbc:h2:mem:studentdb` (config en `application.properties`)
- Consola H2 disponible en: `/h2-console`
- JPA `ddl-auto=update` crea/actualiza tablas según entidades

Credenciales H2 (por defecto):

- JDBC URL: `jdbc:h2:mem:studentdb`
- Usuario: `sa`
- Password: (vacío)

---

## 🧩 Desarrollo y buenas prácticas

- Separar lógica de negocio en `service` si la app crece
- Añadir validaciones con `@Valid` y **DTOs** para evitar exponer entidades directamente
- Manejo de errores: usar `@ControllerAdvice` para respuestas consistentes
- Tests: unitarios para servicios, integraciones con `@SpringBootTest` y `@DataJpaTest`

---

## 🤖 Guía para IA y mantenimiento automático

Meta: facilitar que modelos IA entiendan contexto y actualicen README o código.

Puntos de entrada importantes:

- `StudentApiApplication.java` — arranque
- `controller/StudentController.java` — endpoints
- `model/Student.java` — schema
- `repository/StudentRepository.java` — persistencia

Convenciones:

- paquetes siguen `com.example.student_api` (verificar en repo)
- controladores exponen rutas base `/api/students`
- JPA usa `jakarta.persistence` annotations

Sugerencias de prompts para IA:

- "Agregar validaciones al endpoint POST `/api/students`" → crear DTO, `@Valid`, tests
- "Añadir manejo de errores global para not found" → crear excepción `StudentNotFoundException` y `@ControllerAdvice`
- "Generar tests de integración para CRUD" → añadir `@SpringBootTest` y scripts de ejemplo

Metadatos útiles para IA: `pom.xml` (Spring Boot 3.4.5, Java 21), `application.properties` (H2 config), estructura de paquetes.

---

## 🤝 Cómo contribuir

- Fork + branch con nombre descriptivo
- Tests para cambios nuevos
- PR con descripción clara y pruebas

---

## 🚀 Próximos ajustes

- Añadir capa `service` y DTOs
- Implementar validaciones y manejo de errores
- Añadir autenticación (JWT) para endpoints
- Crear pipeline CI que ejecute tests

---

## 📄 Licencia

MIT