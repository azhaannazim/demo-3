package com.azhaan1.demo.service;

import com.azhaan1.demo.model.Student;
import com.azhaan1.demo.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IServiceStudentTest {
    @Autowired
    private IServiceStudent serviceStudent;
    @MockBean
    private StudentRepo studentRepo;
    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .id(1L)
                .firstName("SEZ")
                .lastName("Beat")
                .email("sezonthebeat@xyz")
                .department("dhh")
                .build();
        Mockito.when(studentRepo.findById(1L)).thenReturn(Optional.of(student));

    }
    @Test
    @DisplayName("get data based valid id")
    @Disabled
    public void whenValidId_thenStudentShouldFound(){
        Long id = 1L;
        Student found = serviceStudent.getStudentById(id);

        assertEquals(id , found.getId());

    }
    
}