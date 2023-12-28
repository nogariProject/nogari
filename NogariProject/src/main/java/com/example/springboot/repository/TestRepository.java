package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, String> {

}