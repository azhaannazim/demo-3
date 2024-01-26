package com.azhaan1.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.validation.annotation.Validated;

@Entity
@Setter
@Getter   //@Data contains all @getter ,@setter,@toString ,@constructor
@Builder

@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "every student must have a firstName")
    private String firstName;
    @NotBlank(message = "every student must have a lastName")
    private String lastName;

    @NaturalId(mutable = true) //to set email unique but can be changed
    private String email;

    private String department;
}
