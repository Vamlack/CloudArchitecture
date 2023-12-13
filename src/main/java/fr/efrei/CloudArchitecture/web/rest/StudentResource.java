package fr.efrei.CloudArchitecture.web.rest;

import fr.efrei.CloudArchitecture.domain.Student;
import fr.efrei.CloudArchitecture.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource (StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/items")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @DeleteMapping("/items")
    public List<Student> deleteStudent() {
        studentService.delete("Thomas");
        return studentService.findAll();
    }
}