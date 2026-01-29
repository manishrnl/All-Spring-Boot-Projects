package com.example.tutorial_11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    BeansLifeCycle p1;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        p1.checkingBeans();

        System.out.println("checking Beans are same or not : " + (p1));
        System.out.println("Beans ID :" + p1.hashCode());
    }
}
