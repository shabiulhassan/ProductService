package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.dtos.SearchRequestDto;
import com.example.productservice.services.SearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService){
        this.searchService=searchService;
    }
    @PostMapping
    public List<GenericProductDto> searchProducts(@RequestBody SearchRequestDto requestDto){
        return searchService.searchProducts(requestDto.getQuery());
    }
}
