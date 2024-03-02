package com.example.productservice;

import com.example.productservice.inheritancerelations.mappedsuperclass.Mentor;
import com.example.productservice.inheritancerelations.mappedsuperclass.MentorRepository;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CatagoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.productservice"})
public class ProductServiceApplication implements CommandLineRunner {

    private final CatagoryRepository catagoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(CatagoryRepository catagoryRepository,
                                     ProductRepository productRepository) {
        this.catagoryRepository = catagoryRepository;
        this.productRepository = productRepository;
    }
//    private MentorRepository mentorRepository;
//    ProductServiceApplication(MentorRepository mentorRepository){
//
//        this.mentorRepository=mentorRepository;
//    }


    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor=new Mentor();
//        mentor.setName("Shabi");
//        mentor.setAvgRating(99.0);
//        mentor.setEmail("shabi@scaler.com");
//        mentorRepository.save(mentor);
//        Category savedCategory=new Category();
//        savedCategory.setName("Apple Phone");
//        catagoryRepository.save(savedCategory);
        Optional<Category> savedCategoryOptional=catagoryRepository.findById(1L);
        if(savedCategoryOptional.isEmpty()){
            throw new Exception("Id not found");
        }
        Category savedCategory=savedCategoryOptional.get();
//        Product savedProduct=new Product();
//        savedProduct.setCategory(savedCategory);
//        savedProduct.setPrice(10);
//        savedProduct.setTitle("Iphone 11 pro");
//        productRepository.save(savedProduct);
//        List<Product> productList=savedCategory.getProducts();
//        for(Product product:productList){
//            System.out.println(product.getTitle());
//        }

    }
}
