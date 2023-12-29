/**
 * 
 */
package com.example.loginrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginrestapi.service.OracleMyBatisService;
import com.example.loginrestapi.vo.OracleMyBatisVo;


@RestController
public class OracleMyBatisController{
	
	@Autowired(required = true)
	private OracleMyBatisService oracleMyBatisService;

	@GetMapping("/selectEmpLists")//Get만 가능
    public ResponseEntity<List<OracleMyBatisVo>> selectEmpList(OracleMyBatisVo parm1) {
        List<OracleMyBatisVo> list = oracleMyBatisService.selectEmpList(parm1);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
	
	@GetMapping("/selectLoginProcess3") //post만 가능
	public ResponseEntity<OracleMyBatisVo> selectLoginProcess3(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultVo); //HttpStatus.OK(정상)HttpStatus.INTERNAL_SERVER_ERROR(500에러)
	}
	
	@GetMapping("/selectLoginProcess")
    public ResponseEntity<OracleMyBatisVo> selectLoginProcess(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
    }

	@RequestMapping("/selectLoginProcess2")//GET과 POST 동시에 다한다
	public ResponseEntity<OracleMyBatisVo> selectLoginProcess2(OracleMyBatisVo parm1) throws Exception{
		OracleMyBatisVo resultVo = oracleMyBatisService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}


}// end 
