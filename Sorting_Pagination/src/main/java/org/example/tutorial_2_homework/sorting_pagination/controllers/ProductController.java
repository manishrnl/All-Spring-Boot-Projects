package org.example.tutorial_2_homework.sorting_pagination.controllers;

import org.example.tutorial_2_homework.sorting_pagination.entity.ProductEntity;
import org.example.tutorial_2_homework.sorting_pagination.repository.PaginationRepository;
import org.example.tutorial_2_homework.sorting_pagination.repository.SortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ProductController {
    private final SortRepository productRepository;
    private final PaginationRepository paginationRepository;

    public ProductController(SortRepository productRepository, PaginationRepository paginationRepository) {
        this.productRepository = productRepository;
        this.paginationRepository = paginationRepository;
    }

    // Illustration of sorting by multiple fields
    @GetMapping("/sort")
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy, Sort sort) {
        return productRepository.findBy(Sort.by(Sort.Direction.DESC,
                sortBy,
                "name", "description"));
        //Sorts in descending order . If two product have same value in sortBy field , then sorts by name and if name is also same then sorts by description
    }

    // Illustration of pagination
    @GetMapping("/page")
    public Page<ProductEntity> getByPage(@RequestParam(defaultValue = "1") Integer pageNo,
                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                         @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return paginationRepository.findBy(pageable);
    }
}
