package com.example.JPA_Tutorial.repository;

import com.example.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CSomeProduct extends JpaRepository<ProductEntity, Long> {
    @Query("select new com.example.JPA_Tutorial.entities.CSomeProduct(p.id , p.title,p.sku) " +
            "from ProductEntity p where p.id=?1")
        // Equivalent to where p.id=:id
    Optional<CSomeProduct> dfhhfghfghfg(@Param("id") Long id);

    //dfhhfghfghfg will return CSomeProduct object as is defined in the query . so no need
    // to write function names as said in Spring documentation like findById ,  findByName etc.,


    // Also function names should not be like in spring documentation like findById ,  findByName etc., in that way it will skip the query and will try to find the data  without looking for the query


    @Query("select new com.example.JPA_Tutorial.entities.CSomeProduct(p.id,p.title,p.sku) from ProductEntity p where p.title = :title")
    Optional<CSomeProduct> sdgdfgdlkfgdfg(String title);
}