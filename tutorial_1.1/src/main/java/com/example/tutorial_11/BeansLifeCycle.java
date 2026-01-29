package com.example.tutorial_11;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope("prototype")
public class BeansLifeCycle {

    void checkingBeans() {
        System.out.println("Beans is created , HashCode : " + hashCode());
    }

    @PostConstruct
    void callThisAfterBeanCreation() {
        System.out.println("Bean is created and ready to use , HashCode :" + hashCode());
    }

    @PreDestroy
    void callThisBeforeBeanDestroy() {
        System.out.println("Destroying Beans , HashCode : " + hashCode());
    }
}
