package com.example.connect_To_Html.Repository;

import com.example.connect_To_Html.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getUserById(Long id);
}
