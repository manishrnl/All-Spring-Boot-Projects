package com.example.tutorial_23.advices;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data

public class ApiResponse<T> {

    private String timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        LocalDateTime currentTime = LocalDateTime.now();
        String monthName = getCamelCase(String.valueOf(currentTime.getMonth()));
        String dayName = getCamelCase(String.valueOf(currentTime.getDayOfWeek()));
        int day = currentTime.getDayOfMonth();
        LocalTime time = LocalTime.now();
        int year = currentTime.getYear();
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        String formattedDateTime =
                dayName + " " + monthName + " " + day + " , " + year + "  " + formattedTime;
        this.timeStamp = formattedDateTime;
    }

    private String getCamelCase(String value) {
        String lowerCase = value.toLowerCase();
        String first = lowerCase.substring(0, 1).toUpperCase();
        String last = lowerCase.substring(1);
        return first + last;
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
