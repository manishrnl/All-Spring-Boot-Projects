package com.example.JPA_Tutorial.repository;

import com.example.JPA_Tutorial.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SortingAndPagingRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("select p.id as id , p.title as title from ProductEntity p ")
    List<ProductEntity> getByIdAndTitle(Long id, String title);
}
