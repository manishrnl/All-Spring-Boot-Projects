package org.example.tutorial_2_homework.sorting_pagination.repository;

import org.example.tutorial_2_homework.sorting_pagination.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SortRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBy(Sort sort);
}
