package nogari.system.commcd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.domain.dto.CommCdDTO;
import nogari.system.commcd.service.CommCdService;

@RestController
@RequestMapping("/common-cds")
@AllArgsConstructor
public class CommCdController {
	
	private final CommCdService service;
	
	//조회
	@GetMapping
	public ResponseEntity<List<ClsCdDTO>> clsCdList(@RequestParam(required=false) String clsCd) throws Exception {
		List<ClsCdDTO> list = service.findClsCd(clsCd);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{clsCd}")
	public ResponseEntity<List<CodeCdDTO>> codeCdList(@PathVariable String clsCd) throws Exception {
		List<CodeCdDTO> list = service.findCodeCd(clsCd);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	//저장
	@PostMapping
	public String clsCdAdd(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.createClsCd(dto);
		
		return str;
	}

	@PostMapping("/{clsCd}")
	public String codeCdAdd(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
		String str = service.createCodeCd(list);
		
		return str;
	}
	
	@PostMapping("/save")
	public String commCdAdd(@RequestBody CommCdDTO dto) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(service.createClsCd(dto.getClsCdDTO())).append("\n");
		sb.append(service.createCodeCd(dto.getCodeCdDTOList())).append("\n");
		
		return sb.toString();
	}
	
	
//	//삭제
//	@DeleteMapping
//	public String clsCdRemove(@RequestBody ClsCdDTO dto) throws Exception {
//		String str = service.deleteClsCd(dto);
//		
//		return str;
//	}
//	
//	@DeleteMapping("/{clsCd}")
//	public String codeCdRemove(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
//		String str = service.deleteCodeCd(list);
//		
//		return str;
//	}
	
	
	//수정
	@PutMapping
	public String clsCdModify(@RequestBody ClsCdDTO dto) throws Exception {
		String str = service.editClsCd(dto);
		
		return str;
	}
	
	@PutMapping("/{clsCd}")
	public String codeCdModify(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) throws Exception {
		String str = service.editCodeCd(list);
		
		return str;
	}
}
