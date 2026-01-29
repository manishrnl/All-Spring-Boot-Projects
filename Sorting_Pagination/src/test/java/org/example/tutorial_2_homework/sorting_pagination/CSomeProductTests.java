package org.example.tutorial_2_homework.sorting_pagination;

import org.example.tutorial_2_homework.sorting_pagination.entity.CSomeProduct;
import org.example.tutorial_2_homework.sorting_pagination.repository.CSomeProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CSomeProductTests {
    @Autowired
    private CSomeProductRepository repository;

    @Test
    public void test1() {
        Optional<CSomeProduct> data = repository.getElementsOfManish(8L);
        System.out.println(data);
    }
}
