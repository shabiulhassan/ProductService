package com.example.productservice.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_mentor")
public class Mentor extends User {
    private Double avgRating;
}
