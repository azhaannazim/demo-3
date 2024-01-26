package com.azhaan1.demo.repository;

import com.azhaan1.demo.model.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase
@Transactional
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .id(1L)
                .firstName("calm")
                .lastName("sm")
                .email("calm@xyz")
                .department("rap")
                .build();
        testEntityManager.persist(student);
    }

    @Test
    public void whenValid_returnStudent(){
        Student found = studentRepo.findById(1L).orElse(null);
        assertEquals("rap", found != null ? found.getDepartment() : null);
    }
}
