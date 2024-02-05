package nogari.system.commcd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

@Mapper
public interface CommCdMapper {
	List<ClsCdDTO> selectClsCd(String clsCd);
	List<CodeCdDTO> selectCodeCd(String clsCd);
	
	void insertClsCd(ClsCdDTO dto);
	void insertCodeCd(CodeCdDTO dto);
	
	void deleteClsCd(ClsCdDTO dto);
	void deleteClsCodeCd(ClsCdDTO dto);
	void deleteCodeCd(CodeCdDTO dto);
	
	void updateClsCd(ClsCdDTO dto);
	void updateCodeCd(CodeCdDTO dto);
	
	int selectClsCdChk(ClsCdDTO dto);
	int selectCodeCdChk(CodeCdDTO dto);
}
