/**
 * 
 */
package com.example.loginrestapi.vo;

import java.util.List;

import com.example.comm.CommonVo;

import lombok.Data;

/**
 *
 */
@Data
public class OracleMyBatisVo extends CommonVo{

	String id;
	String pw;
	String name;
	String nickname;
	String age;
	String address;
	
	List<OracleMyBatisVo> userInfo;

}// end class
