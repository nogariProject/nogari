package nogari.system.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.dept.domain.dto.DeptDTO;
import nogari.system.dept.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired(required=true)
	private DeptService service;
	
	@GetMapping("/dept")
	public List<DeptDTO> selectDept(@RequestBody DeptDTO dto) throws Exception {
		List<DeptDTO> list = service.selectDept(dto);
		
		return list;
	}
	
	@PostMapping("/dept")
	public String insertDept(@RequestBody DeptDTO dto) throws Exception {
		String str = service.insertDept(dto);
		
		return str;
	}
	
	@DeleteMapping("/dept")
	public String deleteDept(@RequestBody DeptDTO dto) throws Exception {
		String str = service.deleteDept(dto);
		
		return str;
	}
	
	@PutMapping("/dept")
	public String updateDept(@RequestBody DeptDTO dto) throws Exception {
		String str = service.updateDept(dto);
		
		return str;
	}
	
}
