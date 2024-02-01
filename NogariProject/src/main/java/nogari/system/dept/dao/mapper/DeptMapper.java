package nogari.system.dept.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nogari.system.dept.domain.dto.DeptDTO;

@Mapper
public interface DeptMapper {
	List<DeptDTO> selectDept(DeptDTO dto);
	void insertDept(DeptDTO dto);
	void deleteDept(DeptDTO dto);
	void updateDept(DeptDTO dto);
	int selectDeptChk(DeptDTO dto);
	int selectUpperDeptChk(DeptDTO dto);
	int selectLowerDeptChk(DeptDTO dto);
	void updateUseDept(DeptDTO dto);
}
