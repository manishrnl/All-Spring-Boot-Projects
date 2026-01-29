package org.example.tutorial_1_homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class WebController {

    @GetMapping("/home")
    public String showGreet0ing() {
        LocalDateTime date = LocalDateTime.now();
        String timeFormatter = date.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String month = date.getMonth().toString();
        String day = date.getDayOfWeek().toString();
        String dateCombined =
                getCamelCase(day) + "   " + getCamelCase(month) + "   " + date.getDayOfMonth() +
                        "  ,  " + date.getYear();
        String heading =
                "<div style = \" align-items:center ; justify-content:center \"><h1> " +
                        "Successfully created a Rest Controller at : " + dateCombined +
                        " Time :" + timeFormatter +
                        "</h1>" + "<button onClick=\"window.location.href='/'\">Bo " +
                        "Back</button></div>";
        return heading;
    }

    public String getCamelCase(String str) {

        String camelCase = "";
        camelCase = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

        return camelCase;
    }

    @GetMapping("/")
    private String greetUser() {
        return "<div style= \"align-items:center ;justify-content:center \">" +
                "<h1>Radhe Radhe , Welcome to Spring Boot Application </h1>" +
                "<h3> In this tutorial I'll perform the homework task assigned to me by my " +
                "teacher Anuj Sir .View it in console.</h3>" +
                "<button onClick=\"window.location.href='/home'\" > Go to Home " +
                "</button>" +
                "</div>";
    }


}

