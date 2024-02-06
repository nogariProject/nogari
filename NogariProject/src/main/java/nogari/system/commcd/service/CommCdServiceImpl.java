package nogari.system.commcd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import nogari.system.commcd.dao.mapper.CommCdMapper;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

@Service("commCdService")
@Transactional
@AllArgsConstructor
public class CommCdServiceImpl implements CommCdService {
	
	private final CommCdMapper mapper;
	
	public List<ClsCdDTO> findClsCd(String clsCd) throws Exception {
		
		return mapper.selectClsCd(clsCd);
	}
	
	public List<CodeCdDTO> findCodeCd(String clsCd) throws Exception {
		
		return mapper.selectCodeCd(clsCd);
	}
	
	
	public String createClsCd(ClsCdDTO dto) throws Exception {
		if(mapper.selectClsCdChk(dto)!=0) {
			return "중복 코드";
		}else {
			mapper.insertClsCd(dto);
			
			return "insert 완료";
		}
	}
	
	public String createCodeCd(List<CodeCdDTO> list) throws Exception {
		StringBuffer result = new StringBuffer();
		for(CodeCdDTO dto : list) {
			if(mapper.selectCodeCdChk(dto)!=0) {
				result.append(dto.getCodeCd()).append(" : 중복 코드\n");
			}else {
				mapper.insertCodeCd(dto);
				result.append(dto.getCodeCd()).append(" : 저장 완료\n");
			}
		}
		return result.toString();
	}
	
	
//	public String deleteClsCd(ClsCdDTO dto) throws Exception {
//
//		mapper.deleteClsCodeCd(dto);
//		mapper.deleteClsCd(dto);
//		
//		return "delete 완료";
//	}
//	
//	public String deleteCodeCd(List<CodeCdDTO> list) throws Exception {
//		StringBuffer result = new StringBuffer();
//		for(CodeCdDTO dto : list) {
//			mapper.deleteCodeCd(dto);
//			result.append(dto.getCodeCd()).append(" : 삭제 완료\n");
//		}
//		return result.toString();
//	}
	
	
	public String editClsCd(ClsCdDTO dto) throws Exception {
		
		mapper.updateClsCd(dto);
		if(dto.getUseYN().equals("N")) {
			mapper.updateClsCodeCd(dto);
		}
		return "update 완료";
	}
	
	public String editCodeCd(List<CodeCdDTO> list) throws Exception {
		StringBuffer result = new StringBuffer();
		for(CodeCdDTO dto : list) {
			mapper.updateCodeCd(dto);
			result.append(dto.getCodeCd()).append(" : 수정 완료\n");
		}
		return result.toString();
	}
}
