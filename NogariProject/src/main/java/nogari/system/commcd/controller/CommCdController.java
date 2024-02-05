package nogari.system.commcd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.service.CommCdService;

@RestController
@RequestMapping("/common-cds")
public class CommCdController {
	@Autowired(required=true)
	private CommCdService service;
	
	//조회
	@GetMapping
	public ResponseEntity<List<ClsCdDTO>> selectClsCd(@RequestParam(required=false) String clsCd) throws Exception {
		List<ClsCdDTO> list = service.selectClsCd(clsCd);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{clsCd}")
	public ResponseEntity<List<CodeCdDTO>> selectCodeCd(@PathVariable String clsCd) throws Exception {
		List<CodeCdDTO> list = service.selectCodeCd(clsCd);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	//저장
	@PostMapping
	public String insertClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.insertClsCd(dto);
		
		return str;
	}

	@PostMapping("/{clsCd}")
	public String insertCodeCd(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
		String str = service.insertCodeCd(list);
		
		return str;
	}
	
//	@PostMapping
//	public String insertClsCd(@RequestBody ClsCdDTO dto, @RequestBody List<CodeCdDTO> list) throws Exception {
//		StringBuffer sb = new StringBuffer();
//		sb.append(service.insertClsCd(dto)).append("\n");
//		sb.append(service.insertCodeCd(list)).append("\n");
//		
//		return sb.toString();
//	}
	
	
	//삭제
	@DeleteMapping
	public String deleteClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.deleteClsCd(dto);
		
		return str;
	}
	
	@DeleteMapping("/{clsCd}")
	public String deleteCodeCd(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
		String str = service.deleteCodeCd(list);
		
		return str;
	}
	
	
	//수정
	@PutMapping
	public String updateClsCd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.updateClsCd(dto);
		
		return str;
	}
	
	@PutMapping("/{clsCd}")
	public String updateCodeCd(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
		String str = service.updateCodeCd(list);
		
		return str;
	}
}
