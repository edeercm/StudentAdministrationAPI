package com.example.student_api.controller;

import com.example.student_api.model.Student;
import com.example.student_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Agregar un nuevo estudiante
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // Actualizar un estudiante por su ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setAge(studentDetails.getAge());
            return repository.save(student);
        } else {
            // Si no existe, se puede lanzar una excepción o manejarlo de otra forma
            return null;
        }
    }

    // Eliminar un estudiante por su ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

/* -- 📝 Explicación rápida:
  @RestController: Indica que esta clase expone endpoints REST.
  @RequestMapping("/api/students"): Ruta base para todos los métodos.
  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Manejan los distintos tipos de solicitudes HTTP.
  @RequestBody: El cuerpo del JSON se convierte automáticamente en un objeto Student.
  @PathVariable: Extrae el id desde la URL.
*/