package nogari.system.commcd.service;

import java.util.List;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

public interface CommCdService {
	public List<ClsCdDTO> findClsCd(String clsCd) throws Exception;
	public List<CodeCdDTO> findCodeCd(String clsCd) throws Exception;
	
	public String createClsCd(ClsCdDTO dto) throws Exception;
	public String createCodeCd(List<CodeCdDTO> list) throws Exception;
	
//	public String deleteClsCd(ClsCdDTO dto) throws Exception;
//	public String deleteCodeCd(List<CodeCdDTO> list) throws Exception;
	
	public String editClsCd(ClsCdDTO dto) throws Exception;
	public String editCodeCd(List<CodeCdDTO> list) throws Exception;
}
