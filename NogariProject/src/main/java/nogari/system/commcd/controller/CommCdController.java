package nogari.system.commcd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.service.CommCdService;

@RestController
public class CommCdController {
	@Autowired(required=true)
	private CommCdService service;
	
	@GetMapping("/clscd")
	public List<Map<String, Object>> selectClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		List<Map<String, Object>> list = service.selectClsCd(dto);
		
		return list;
	}
	
	@GetMapping("/codecd")
	public List<Map<String, Object>> selectCodeCd(@RequestBody CodeCdDTO dto) throws Exception {
		List<Map<String, Object>> list = service.selectCodeCd(dto);
		
		return list;
	}
	
	@PostMapping("/clscd")
	public String insertClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.insertClsCd(dto);
		
		return str;
	}

	@PostMapping("/codecd")
	public String insertCodeCd(@RequestBody CodeCdDTO dto) throws Exception {
		String str = service.insertCodeCd(dto);
		
		return str;
	}
	
	@DeleteMapping("/clscd")
	public String deleteClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.deleteClsCd(dto);
		
		return str;
	}
	
	@DeleteMapping("/codecd")
	public String deleteCodeCd(@RequestBody CodeCdDTO dto) throws Exception {
		String str = service.deleteCodeCd(dto);
		
		return str;
	}
	
	@PutMapping("/clscd")
	public String updateClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.updateClsCd(dto);
		
		return str;
	}
	
	@PutMapping("/codecd")
	public String updateCodeCd(@RequestBody CodeCdDTO dto) throws Exception {
		String str = service.updateCodeCd(dto);
		
		return str;
	}
}
