package org.example.tutorial_2_homework.sorting_pagination.repository;

import org.example.tutorial_2_homework.sorting_pagination.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginationRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findBy(Pageable pageable);
}
