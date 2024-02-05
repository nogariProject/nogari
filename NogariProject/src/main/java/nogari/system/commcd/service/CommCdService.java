package nogari.system.commcd.service;

import java.util.List;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

public interface CommCdService {
	public List<ClsCdDTO> selectClsCd(String clsCd) throws Exception;
	public List<CodeCdDTO> selectCodeCd(String clsCd) throws Exception;
	
	public String insertClsCd(ClsCdDTO dto) throws Exception;
	public String insertCodeCd(List<CodeCdDTO> list) throws Exception;
	
	public String deleteClsCd(ClsCdDTO dto) throws Exception;
	public String deleteCodeCd(List<CodeCdDTO> list) throws Exception;
	
	public String updateClsCd(ClsCdDTO dto) throws Exception;
	public String updateCodeCd(List<CodeCdDTO> list) throws Exception;
}
