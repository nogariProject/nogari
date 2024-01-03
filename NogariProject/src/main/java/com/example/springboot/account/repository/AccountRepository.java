package com.example.springboot.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.MemberEntity;

public interface AccountRepository extends JpaRepository<MemberEntity, String> {

}