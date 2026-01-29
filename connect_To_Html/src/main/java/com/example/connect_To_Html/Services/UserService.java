package com.example.connect_To_Html.Services;

import com.example.connect_To_Html.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    String save(UserEntity user);

    UserEntity getUserById(Long userId);

    boolean deleteUserById(Long userId);

    void updateUser(Long userId, UserEntity userEntity);
}
