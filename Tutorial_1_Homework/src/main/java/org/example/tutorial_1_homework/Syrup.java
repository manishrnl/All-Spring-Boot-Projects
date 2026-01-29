package org.example.tutorial_1_homework;
import org.springframework.stereotype.Component;

@Component
public class Syrup {

    String syrupType = "Vanilla";

    String getType() {
        return "Syrup Type not Configured . Default is :" + syrupType;
    }
}
