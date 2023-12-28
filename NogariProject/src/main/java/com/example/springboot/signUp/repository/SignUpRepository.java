package com.example.springboot.signUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.MemberEntity;

public interface SignUpRepository extends JpaRepository<MemberEntity, String> {

}