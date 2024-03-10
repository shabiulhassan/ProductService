package com.example.productservice;

import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
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
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceApplication(ProductRepository productRepository,
                                     PriceRepository priceRepository,
                                     CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
    }
//    private MentorRepository mentorRepository;
//    ProductServiceApplication(MentorRepository mentorRepository){
//
//        this.mentorRepository=mentorRepository;
//    }


    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);

    }
@Transactional
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
//        Optional<Category> savedCategoryOptional=catagoryRepository.findById(1L);
//        if(savedCategoryOptional.isEmpty()){
//            throw new Exception("Id not found");
//        }
        //Category savedCategory=savedCategoryOptional.get();
//        Product savedProduct=new Product();
//        savedProduct.setCategory(savedCategory);
//        savedProduct.setPrice(10);
//        savedProduct.setTitle("Iphone 11 pro");
//        productRepository.save(savedProduct);
//        List<Product> productList=savedCategory.getProducts();
//        for(Product product:productList){
//            System.out.println(product.getTitle());
//        }
//        Category savedCategory=new Category();
//        savedCategory.setName("Phone");
//        Price savedPrice=new Price();
//        savedPrice.setCurrency("INR");
//        savedPrice.setValue(100000);
//        Product savedProduct=new Product();
//        savedProduct.setTitle("Iphone 11");
//        savedProduct.setPrice(savedPrice);
//        savedProduct.setCategory(savedCategory);
//        savedProduct.setDescription("good phone");
//        savedProduct.setImage("IMG");
//        productRepository.save(savedProduct);
//        Optional<Price> savedPriceOptional=priceRepository.findById(1L);
//        if(savedPriceOptional.isEmpty()){
//            throw new Exception("Price not found");
//        }
//        Price savedPrice=savedPriceOptional.get();
//
//        Optional<Category> savedCategoryOptional=categoryRepository.findById(1L);
//        if(savedCategoryOptional.isEmpty()){
//            throw new Exception("category not found");
//        }
//        Category savedCategory=savedCategoryOptional.get();
//        Product savedProduct=new Product();
//        savedProduct.setTitle("Iphone 13");
//        savedProduct.setPrice(savedPrice);
//        savedProduct.setCategory(savedCategory);
//        savedProduct.setDescription("best phone");
//        savedProduct.setImage("IMG");
//        productRepository.save(savedProduct);
//         List<Product> product=productRepository.findByImage("IMG");
//         for(Product p: product){
//             System.out.println(p.getTitle());
//         }
//        List<Category> categories=categoryRepository.findByName("Phone");
//        for(Category c: categories){
//            List<Product> p=c.getProducts();
//        }
//          List<Product> products=productRepository.findByMe();
//          for(Product p: products){
//           System.out.println(p.getTitle());
//        }

    }
}
