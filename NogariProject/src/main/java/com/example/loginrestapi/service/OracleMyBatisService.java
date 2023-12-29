package com.example.loginrestapi.service;

import java.util.List;

import com.example.loginrestapi.vo.OracleMyBatisVo;

public interface OracleMyBatisService {

	int selectCountEmp(OracleMyBatisVo parm1);

	List<OracleMyBatisVo> selectEmpList(OracleMyBatisVo parm1);

	OracleMyBatisVo selectLoginProcess(OracleMyBatisVo parm1) throws Exception;

}