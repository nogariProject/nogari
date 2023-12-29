package com.example.springboot.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.login.domain.Member;

@Mapper
@Repository
public interface LoginMapper {
	Member selectMemberById(Map<String, String> param);

	int insertMember(Map<String, String> param);

	List<Member> selectAllMembers();

	int deleteMember(Map<String, String> param);
}
