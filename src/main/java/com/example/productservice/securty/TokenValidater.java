package com.example.productservice.securty;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidater {
    private RestTemplateBuilder restTemplateBuilder;
    TokenValidater(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public Optional<JWTObject> validateToken(String token){
        RestTemplate restTemplate=restTemplateBuilder.build();
        return null;

    }
}
