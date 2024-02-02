package com.example.springboot.data.repository;

import com.example.springboot.data.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    @Modifying
    @Query("update User u set u.password=:password, u.username=:username, u.authority=:authority where u.id=:id")
    Integer updateUserById(@Param("id")long id, @Param("username")String username, @Param("password")String password, @Param("authority")String authority);
}
