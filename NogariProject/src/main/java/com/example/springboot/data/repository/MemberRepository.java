package com.example.springboot.data.repository;

import com.example.springboot.data.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {


}
