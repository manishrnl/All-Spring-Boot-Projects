package com.example.JPA_Tutorial.controller;

import com.example.JPA_Tutorial.entities.ProductEntity;
import com.example.JPA_Tutorial.repository.SortingAndPagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/sort")

public class SortingAndPagingController {
    private static final int DEFAULT_PAGE_SIZE = 10;
    //    private final SortingAndPagingRepository sortingRepository;
//
//    public SortingAndPagingController(SortingAndPagingRepository sortingRepository) {
//        this.sortingRepository = sortingRepository;
//    }
    @Autowired
    private SortingAndPagingRepository sortingRepository;

    //use link  :-> http://localhost:2009/sort?sortBy=price&pageNumber=1
    @GetMapping("/filter")
    public List<ProductEntity> sortss(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") int pageNumber) {

        return sortingRepository.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pageNumber, DEFAULT_PAGE_SIZE, Sort.by(sortBy)));
    }


}
