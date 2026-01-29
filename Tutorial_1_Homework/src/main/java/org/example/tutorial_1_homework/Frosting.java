package org.example.tutorial_1_homework;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Frosting implements FrostingInterface {

    String frostingType = "chocolate";

    public String getType() {
        return "Frosting type is not configured . default is " + frostingType;
    }
}
