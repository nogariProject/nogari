package com.example.loginrestapi.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.loginrestapi.vo.OracleMyBatisVo;


@Mapper
public interface OracleMyBatisMapper {

	List<OracleMyBatisVo> selectEmpList(OracleMyBatisVo param1);

	int selectCountEmp(OracleMyBatisVo param1);

	int selectCountEmpPw(OracleMyBatisVo paramVo1);

}//end 
