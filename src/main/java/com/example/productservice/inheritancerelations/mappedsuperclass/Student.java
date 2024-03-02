package com.example.productservice.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Getter
@Setter
@Entity(name = "msc_student")
public class Student extends User{
    private Double psp;
}
