package org.example.tutorial_2_homework.sorting_pagination.repository;

import org.example.tutorial_2_homework.sorting_pagination.entity.CSomeProduct;
import org.example.tutorial_2_homework.sorting_pagination.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CSomeProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select new org.example.tutorial_2_homework.sorting_pagination.entity.CSomeProduct(p.id ,p.description,p.oldPrice) from ProductEntity p where p" +
            ".id=:id")
    Optional<CSomeProduct> getElementsOfManish(Long id);
}
