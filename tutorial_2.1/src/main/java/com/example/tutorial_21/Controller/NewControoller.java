package com.example.tutorial_21.Controller;

import com.example.tutorial_21.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class NewControoller {

    @Autowired
    UsersDTO usersDTO;

    @GetMapping("/{id}")
    private UsersDTO home(@PathVariable int id) {
        return new UsersDTO(id, "Manish", "Madhubani", 9501421887L);
    }

    @PostMapping("/{name}/{mobile}")
    private UsersDTO postMapertwe(@PathVariable String name, @PathVariable long mobile) {
        usersDTO.setName(name);
        usersDTO.setMobile(mobile);
        return usersDTO;
    }

    @PutMapping()
    private String put() {
        return "<h1>This is Put Mapping</h1>";
    }

    @PatchMapping()
    private String patch() {
        return "<h1>This is Patch Mapping</h1>";
    }

    @DeleteMapping()
    private String delete() {
        return "<h1>This is Delete Mapping</h1>";
    }
}
