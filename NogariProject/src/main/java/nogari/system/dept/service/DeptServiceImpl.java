package nogari.system.dept.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.system.dept.dao.mapper.DeptMapper;
import nogari.system.dept.domain.dto.DeptDTO;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService{
	
	@Resource
	private DeptMapper mapper;

	public List<DeptDTO> selectDept(DeptDTO dto) throws Exception {
		
		return mapper.selectDept(dto);
	}
	
	public String insertDept(DeptDTO dto) throws Exception {
		if(mapper.selectDeptChk(dto)!=0) {
			return "중복";
		}else if(dto.getUpperDeptCd()==null) {
			mapper.insertDept(dto);
			
			return "insert 완료";
		}else if(dto.getUpperDeptCd()!=null && mapper.selectUpperDeptChk(dto)==0) {
			return "해당 상위 부서 존재하지 않음";
		}else {
			mapper.insertDept(dto);
				
			return "insert 완료";
		}
	}
	
	public String deleteDept(DeptDTO dto) throws Exception {
		if(mapper.selectLowerDeptChk(dto)!=0) {
			return "사용중인 하위 부서 존재";
		}else {
			mapper.updateUseDept(dto);
			
			return "delete 완료";
		}
	}
	
	public String updateDept(DeptDTO dto) throws Exception {
		
		mapper.updateDept(dto);
		
		return "update 완료";
	}
	
}
