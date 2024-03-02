package com.example.productservice.inheritancerelations.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@DiscriminatorValue(value = "1")
public class Ta extends User {
    private int totalQuestionsSolved;
}
