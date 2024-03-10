package com.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn
    private Price price;
    private String image;
    @ManyToOne
    @JoinColumn
    private Category category;

}
