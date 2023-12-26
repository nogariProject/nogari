package com.example.springboot.Repository;

import com.example.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {


}