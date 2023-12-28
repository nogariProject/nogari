package com.example.springboot.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.login.domain.MemberVO;

@Mapper
@Repository
public interface LoginMapper {
	MemberVO selectMemberById(Map<String, String> param);

	int insertMember(Map<String, String> param);

	List<MemberVO> selectAllMembers();
}
