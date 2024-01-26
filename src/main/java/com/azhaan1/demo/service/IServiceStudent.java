package com.azhaan1.demo.service;
import com.azhaan1.demo.model.Student;

import java.util.List;

public interface IServiceStudent {
     Student addStudent(Student Student);
     List<Student> getAllStudents();
     Student updateStudent(Long id , Student Student);
     Student getStudentById(Long id);
     void deleteStudent(Long id);
}
