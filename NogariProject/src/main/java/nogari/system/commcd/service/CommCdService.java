package nogari.system.commcd.service;

import java.util.List;
import java.util.Map;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

public interface CommCdService {
	public List<Map<String, Object>> selectClsCd(ClsCdDTO dto) throws Exception;
	public List<Map<String, Object>> selectCodeCd(CodeCdDTO dto) throws Exception;
	public String insertClsCd(ClsCdDTO dto) throws Exception;
	public String insertCodeCd(CodeCdDTO dto) throws Exception;
	public String deleteClsCd(ClsCdDTO dto) throws Exception;
	public String deleteCodeCd(CodeCdDTO dto) throws Exception;
	public String updateClsCd(ClsCdDTO dto) throws Exception;
	public String updateCodeCd(CodeCdDTO dto) throws Exception;
}
