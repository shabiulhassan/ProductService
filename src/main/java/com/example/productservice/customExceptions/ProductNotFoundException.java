package com.example.productservice.customExceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}