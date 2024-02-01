package nogari.system.dept.service;

import java.util.List;

import nogari.system.dept.domain.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> selectDept(DeptDTO dto) throws Exception;
	public String insertDept(DeptDTO dto) throws Exception;
	public String deleteDept(DeptDTO dto) throws Exception;
	public String updateDept(DeptDTO dto) throws Exception;
}
