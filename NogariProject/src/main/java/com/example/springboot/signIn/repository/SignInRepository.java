package com.example.springboot.signIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.MemberEntity;

public interface SignInRepository extends JpaRepository<MemberEntity, String> {

}