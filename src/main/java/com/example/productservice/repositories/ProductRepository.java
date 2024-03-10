package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    <S extends Product> S save(S entity);

    List<Product> findBytitle(String s);
    List<Product> findByImage(String s);
    @Query(value = "select * from Product ",nativeQuery = true)
    List<Product> findByMe();
}
