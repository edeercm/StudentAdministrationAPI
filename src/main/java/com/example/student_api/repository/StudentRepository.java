package com.example.student_api.repository;

import com.example.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz permite operaciones CRUD automáticas
public interface StudentRepository extends JpaRepository<Student, Long> {
}


/* -- 📝 ¿Qué hace este código?
  JpaRepository<Student, Long>: Le dice a Spring que queremos una interfaz que trabaje con entidades de tipo Student y que su ID es de tipo Long.

  Al extender JpaRepository, no necesitas escribir código para operaciones básicas como guardar, buscar, eliminar o actualizar. Spring lo hace por ti.

  Con esto listo, ya puedes hacer operaciones CRUD sin escribir lógica extra todavía.
*/