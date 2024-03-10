package com.example.productservice.controllers;

import com.example.productservice.customExceptions.ProductNotFoundException;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    ProductController productController;

    @Test
    @DisplayName("Testing 1+1=2")
    void testOnePlusOneIsTwo(){
        //assert(2==1+1);
        assertEquals(2,1+1,"1+1 should be 2");
    }
@Test
    void testGetProductByIdNegativeTC(){
        assertThrows(ProductNotFoundException.class,()->productController.getProductById(1000L));
    }
}
