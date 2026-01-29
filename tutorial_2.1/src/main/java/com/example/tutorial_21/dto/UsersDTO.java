package com.example.tutorial_21.dto;

import org.springframework.stereotype.Service;

@Service

public class UsersDTO {
    private int id;
    private String name;
    private String city;
    private long mobile;


    public UsersDTO() {
    }

    public UsersDTO(int id, String name, String city, long mobile) {
        this.id = id;
        this.city = city;
        this.mobile = mobile;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
