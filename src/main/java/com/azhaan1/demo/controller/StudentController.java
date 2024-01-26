package com.azhaan1.demo.controller;

import com.azhaan1.demo.model.Student;
import com.azhaan1.demo.service.IServiceStudent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this will tell that this class is responsible for control all the rest API
@RequestMapping("/student")
@RequiredArgsConstructor //generates constructors for final class
public class  StudentController {
    @Autowired
    private final IServiceStudent studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }
    @PostMapping
    public Student addStudents(@RequestBody @Valid Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id ,@RequestBody Student student){
        return studentService.updateStudent(id ,student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
