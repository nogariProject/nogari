package com.example.springboot.Repository;

import com.example.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByLoginId(String loginId);
}