package com.example.connect_To_Html.controller;

import com.example.connect_To_Html.Repository.UserRepository;
import com.example.connect_To_Html.Services.UserService;
import com.example.connect_To_Html.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/editUser/{userId}")
    public String editUserById(@PathVariable Long userId, Model model) {
        System.out.println("Editing user");
        UserEntity userEntity=userService.getUserById(userId);
        model.addAttribute("user",userEntity);
        return "editUser";
    }

    @PutMapping("/editUser/{userId}")
    public String updateUser(@PathVariable Long userId, @ModelAttribute("editUser") UserEntity user) {
        userService.updateUser(userId, user);
        return "redirect:/users";
    }



    @GetMapping("/form")
    public String showForm(@RequestParam(value = "id", required = false) Long id,
                           Model model) {
        UserEntity userEntity;
        if (id != null) {
            userEntity = userService.getUserById(id);
            if (userEntity == null) {
                userEntity = new UserEntity();
                model.addAttribute("errorMessage", "Users not found");
            }
        } else {
            userEntity = new UserEntity();
        }
        model.addAttribute("user", userEntity);
        return "userForm";
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        // Example: Fetch all users (replace with your actual repository or service)
        List<UserEntity> userList = userService.getAllUsers();

        model.addAttribute("users", userList);
        return "viewUser"; // this resolves to users.html
    }

    @GetMapping("/about")
    public String aboutUsers() {

        return "about"; // this resolves to users.html
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("user") UserEntity user, Model model) {
        String message = userService.save(user);
        if (!"Saved Successfully".equals(message)) {
            model.addAttribute("errorMessage", message);
            model.addAttribute("user", user);
            return "userForm";
        }
        // Success
        model.addAttribute("successMessage", "Submitted successfully!");
        model.addAttribute("user", user);
        return "confirmation";
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId, RedirectAttributes redirectAttributes) {
        boolean deleted = userService.deleteUserById(userId);
        if (deleted) {
            redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete user.");
        }
        return "redirect:/users";
    }


}
