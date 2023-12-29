/**
 * 
 */
package com.example.loginrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.example.comm.exception.NogariExcaption;
import com.example.comm.filter.ReadableRequestWrapperFilter;
import com.example.loginrestapi.service.OracleMyBatisService;
import com.example.loginrestapi.vo.OracleMyBatisVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("oracleMyBatisService")
public class OracleMyBatisServiceImpl implements OracleMyBatisService{
	
	
	@Autowired(required = true)
	private OracleMyBatisMapper oracleMyBatisMapper;
	

	@Override
	public List<OracleMyBatisVo> selectEmpList(OracleMyBatisVo param1) {
		return oracleMyBatisMapper.selectEmpList(param1);
	}


	@Override
	public int selectCountEmp(OracleMyBatisVo param1) {
		return oracleMyBatisMapper.selectCountEmp(param1);
	}


	@Override
	public OracleMyBatisVo selectLoginProcess(OracleMyBatisVo parm1)  throws Exception{
		
		log.error("시작");

		OracleMyBatisVo resultVo = new OracleMyBatisVo();
		
		try {
			
			
			String msg     = "";
			String errCd   = "";
			
			
			OracleMyBatisVo paramVo1 = new OracleMyBatisVo();
			paramVo1.setId(parm1.getId());
			
			int idCnt  = oracleMyBatisMapper.selectCountEmp(paramVo1);
			
			paramVo1.setPw(parm1.getPw());

			int pwCnt  = oracleMyBatisMapper.selectCountEmpPw(paramVo1);
			
			List<OracleMyBatisVo> userInfo = null;
			
			//건수가 있으면 정보리턴
			if(idCnt == 0) {
				msg      = "없는 ID입니다 다시한번 확인해주세요";
				errCd    = "E00001";
			}else if (idCnt > 0 && pwCnt == 0) {
				msg      = "틀린 패스워드입니다. 확인해주세요.";
				errCd    = "E00001";
			}else if (idCnt >0 && pwCnt > 0 ) {
				msg      = "로그인 성공";
				errCd    = "S00001";
				userInfo = oracleMyBatisMapper.selectEmpList(parm1);
			}else {
				msg      = "로그인 실패";
				errCd    = "E00001";
			}

			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
			resultVo.setUserInfo(userInfo);
			
			
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
		
	}
	
	

}// end
