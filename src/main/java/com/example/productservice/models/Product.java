package com.example.productservice.models;

import com.example.productservice.dtos.GenericProductDto;
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
    public GenericProductDto from(Product product){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setPrice(product.getPrice().getValue());
        genericProductDto.setImage(product.getImage());
        return genericProductDto;
    }

}
