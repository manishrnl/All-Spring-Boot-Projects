package org.example.tutorial_1_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tutorial1HomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Tutorial1HomeworkApplication.class, args);
    }

    @Autowired
    private Frosting frosting;

    @Autowired
    private Syrup syrup;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(frosting.getType());
        System.out.println(syrup.getType());

    }
}
