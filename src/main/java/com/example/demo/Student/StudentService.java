package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudent(){
        return  studentRepository.findAll();

    }
    @PostMapping
    public void addNewStudent(Student student) {
        Optional<Student> studentByemail= studentRepository.findStudentByDob(student.getDob());
        if(studentByemail.isPresent()){
            throw new IllegalStateException("user dob exist");
        }
        studentRepository.save(student);
        System.out.print(student.getNom());
    }

    @DeleteMapping
    public void DeleteStudent(long id) {
        boolean exists= studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("l'utilisateur n'existe pas");
        }
        studentRepository.deleteById(id);
    }
}
