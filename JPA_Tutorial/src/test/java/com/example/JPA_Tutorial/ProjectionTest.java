package com.example.JPA_Tutorial;

import com.example.JPA_Tutorial.repository.CSomeProduct;
import com.example.JPA_Tutorial.repository.SortingAndPagingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class ProjectionTest {
    @Autowired
    private SortingAndPagingRepository repository;
    @Autowired
    private CSomeProduct cSomeProduct;

    @Test
    public void test1() {
        System.out.println("ProjectionTest.test1");
    }

    @Test
    public void test2() {
        Optional<CSomeProduct> data = cSomeProduct.dfhhfghfghfg(5L);
        //dfhhfghfghfg will return CSomeProduct object as is defined in the query . so no need to write function names as said in Spring documentation like findById ,  findByName etc,

        // Also function names should not be like in spring documentation like findById ,  findByName etc , in that way it will skips the query and will try to find the data  without looking for the query
        System.out.println(data);
    }

    @Test
    public void test3() {
        Optional<CSomeProduct> data = cSomeProduct.sdgdfgdlkfgdfg("LaPTop");
        System.out.println(data);
    }

}
