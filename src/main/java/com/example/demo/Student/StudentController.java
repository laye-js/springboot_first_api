package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
   private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService= studentService;
    }
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping
    public void RegisterStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{StudenId}")
    public void DeleteStudent(@PathVariable("StudenId") long id){
        studentService.DeleteStudent(id);
    }


}
