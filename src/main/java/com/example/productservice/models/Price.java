package com.example.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Price extends BaseModel{
    String currency;
    int value;
}
