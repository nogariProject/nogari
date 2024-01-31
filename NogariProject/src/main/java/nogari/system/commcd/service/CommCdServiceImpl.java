package nogari.system.commcd.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.system.commcd.dao.mapper.CommCdMapper;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

@Service("commCdService")
@Transactional
public class CommCdServiceImpl implements CommCdService {
	@Resource
	private CommCdMapper mapper;
	
	public List<Map<String, Object>> selectClsCd(ClsCdDTO dto) throws Exception {
		
		return mapper.selectClsCd(dto);
	}
	
	public List<Map<String, Object>> selectCodeCd(CodeCdDTO dto) throws Exception {
		
		return mapper.selectCodeCd(dto);
	}
	
	public String insertClsCd(ClsCdDTO dto) throws Exception {
		if(mapper.selectClsCdChk(dto)!=0) {
			return "중복 코드";
		}else {
			mapper.insertClsCd(dto);
			
			return "insert 완료";
		}
	}
	
	public String insertCodeCd(CodeCdDTO dto) throws Exception {
		if(mapper.selectCodeCdChk(dto)!=0) {
			return "중복 코드";
		}else {
			mapper.insertCodeCd(dto);
			
			return "insert 완료";
		}
	}
	
	public String deleteClsCd(ClsCdDTO dto) throws Exception {
		
		mapper.deleteClsCd(dto);
		
		return "delete 완료";
	}
	
	public String deleteCodeCd(CodeCdDTO dto) throws Exception {
		
		mapper.deleteCodeCd(dto);
		
		return "delete 완료";
	}
	
	public String updateClsCd(ClsCdDTO dto) throws Exception {
		
		mapper.updateClsCd(dto);
		
		return "update 완료";
	}
	
	public String updateCodeCd(CodeCdDTO dto) throws Exception {
		
		mapper.updateCodeCd(dto);
		
		return "update 완료";
	}
}
