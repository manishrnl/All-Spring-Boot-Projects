package com.example.JPA_Tutorial;

import com.example.JPA_Tutorial.entities.ProductEntity;
import com.example.JPA_Tutorial.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DatabaseTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void getByTitle() {
        Optional<ProductEntity> fetchData = productRepository.getProductEntityByTitle("Mouse");
        System.out.println(fetchData);
    }

    @Test
    public void findBySku() {
        Optional<ProductEntity> fetchData = productRepository.findBySku("SKU005");
        System.out.println(fetchData);
    }

    @Test
    public void searchBySku() {
        Optional<ProductEntity> fetchData = productRepository.searchBySku("SKU005");
        System.out.println(fetchData);
    }

    @Test
    public void getBySku() {
        Optional<ProductEntity> fetchData = productRepository.getBySku("SKU005");
        System.out.println(fetchData);
    }

    @Test
    public void queryBySku() {
        Optional<ProductEntity> fetchData = productRepository.queryBySku("SKU005");
        System.out.println(fetchData);
    }

    @Test
    public void readBySku() {
        Optional<ProductEntity> fetchData = productRepository.readBySku("SKU005");
        System.out.println(fetchData);
    }

    List<String> value = new ArrayList<>();

    @Test
    public void streamBySku() {
        Optional<ProductEntity> fetchData = productRepository.streamBySku("SKU005");
//        System.out.println(fetchData.stream().map(value -> "Id : = " + value.getId() + " SKU = " + value.getSku()));
        System.out.println(fetchData.map(value ->"\nId : " + value.getId() +
                        "\nSKU = " + value.getSku() +
                        "\nTitle = " + value.getTitle()

        ));

    }

    @Test
    public void getBy3And() {
        Optional<ProductEntity> fetchData = productRepository.getBySkuAndTitleAndPrice(
                "SKU005", "Mouse", BigDecimal.valueOf(35.00));
        System.out.println(fetchData);
    }

    @Test
    public void getBy3Or() {
        List<ProductEntity> fetchData = productRepository.getBySkuOrTitleOrPrice(
                "SKU007", "Mouse", BigDecimal.valueOf(125));
        System.out.println(fetchData);
    }

    @Test
    public void existsBy2() {
        Boolean fetchData = productRepository.existsByTitle("Webcam");
        System.out.println(fetchData);
    }

    @Test
    public void count() {
        int fetchData = productRepository.countByQuantity(25);
        System.out.println(fetchData);
    }

    @Test
    public void delete() {
        long deletedCount = productRepository.deleteByQuantity(110);
        System.out.println("Deleted " + deletedCount + " products.");

    }

    @Test
    public void delete2() {
        long deletedCount = productRepository.removeByQuantity(100);
        System.out.println("Deleted " + deletedCount + " products.");

    }

    @Test
    public void delete3() {
        productRepository.deleteById(33L);
        System.out.println("Deleted Successfully with ids :33");
    }

    @Test
    public void after() {
        List<ProductEntity> isAfter =
                productRepository.getByCreatedAtIsAfter(LocalDateTime.parse("2025-10-10T10" +
                        ":00:00.000000"));
        System.out.println("* * * * * * * * * * * * * * *");
        isAfter.forEach(e -> {
            System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *");
        });
    }

    @Test
    public void isBefore() {
        List<ProductEntity> isBefore = productRepository.getByCreatedAtIsBefore(LocalDateTime.parse("2025-10-10T10:00:00.000000"));

        System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
        isBefore.forEach(e -> {
            System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *");
        });
    }

    @Test
    public void containingTutorial() {
        List<ProductEntity> containingTitle = productRepository.getByTitleIsContaining(
                "Ead");
        containingTitle.forEach(e ->
                System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *")
        );
    }

    @Test
    public void endswithTuts() {
        List<ProductEntity> endsWithTitle = productRepository.findByTitleEndingWith("SeT");
        endsWithTitle.forEach(e ->
                System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *")
        );
    }

    @Test
    public void greaterEquals() {
        List<ProductEntity> greater =
                productRepository.getByQuantityGreaterThanEqualOrderByQuantityAsc(20L);
        greater.forEach(e ->
                System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *")
        );
    }

    @Test
    public void likeTuts() {
        List<ProductEntity> fetchData = productRepository.getByTitleLike("OaSTe");
        if (fetchData == null || fetchData.size() == 0) {
            System.out.println("No Data Found");
            return;
        }
        fetchData.forEach(e ->
                System.out.println(e + "\n * * * * * * * * * * * * * * * * * *  *")
        );
    }

}
