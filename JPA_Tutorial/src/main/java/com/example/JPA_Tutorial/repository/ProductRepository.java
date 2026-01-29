package com.example.JPA_Tutorial.repository;

import com.example.JPA_Tutorial.entities.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> getProductEntityByTitle(String titasdfle);

    Optional<ProductEntity> findBySku(String Skeru);

    Optional<ProductEntity> searchBySku(String Sdku);

    Optional<ProductEntity> getBySku(String Sval43ku);

    Optional<ProductEntity> queryBySku(String val);

    Optional<ProductEntity> readBySku(String val);

    Optional<ProductEntity> streamBySku(String val);

    Optional<ProductEntity> getBySkuAndTitleAndPrice(String val3, String val1,
                                                     BigDecimal val2);

    List<ProductEntity> getBySkuOrTitleOrPrice(String sku, String title,
                                               BigDecimal price);

    Boolean existsByTitle(String value);

    int countByQuantity(int value);

    @Transactional
    Long deleteByQuantity(int value);

    @Transactional
    Long removeByQuantity(int i);


    List<ProductEntity> getByCreatedAtIsAfter(LocalDateTime after);

    List<ProductEntity> getByCreatedAtIsBefore(LocalDateTime before);

    List<ProductEntity> getByTitleIsContaining(String title);

    List<ProductEntity> findByTitleEndingWith(String seT);

    List<ProductEntity> getByQuantityGreaterThanEqualOrderByQuantityAsc(long l);

    List<ProductEntity> getByTitleLike(String s);


}
