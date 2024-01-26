package com.azhaan1.demo.service;

import com.azhaan1.demo.Exception.StudentAlreadyExistsException;
import com.azhaan1.demo.Exception.StudentNotFountException;
import com.azhaan1.demo.model.Student;
import com.azhaan1.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements IServiceStudent {
    private final StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Student addStudent(Student student) {
        if(StudentAlreadyExist(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getEmail() + " Already Exist!");
        }
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepo.findById(id).map(st ->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());

            return studentRepo.save(st);
        }).orElseThrow(() -> new StudentNotFountException(student.getId() + " doesnot exist!"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).
                orElseThrow(() -> new StudentNotFountException("student with " + id + " not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepo.existsById(id)){
            throw new StudentNotFountException("student with " + id + " not found");
        }
        studentRepo.deleteById(id);
    }

    private boolean StudentAlreadyExist(String email) {
        return studentRepo.findByEmail(email).isPresent();
    }
}
