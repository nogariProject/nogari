package nogari.system.commcd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import nogari.system.commcd.dao.mapper.CommCdMapper;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.domain.dto.CommCdDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class CommCdServiceImpl implements CommCdService {

    private final CommCdMapper mapper;

    /**
     * <pre>
     *  대분류 코드 조회
     * </pre>
     * 
     * @param 검색을 위해 입력받은 문자열
     * @return 조회조건에 맞는 대분류 코드
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClsCdDTO> findClsCd(String clsCd) {

        return mapper.selectClsCd(clsCd);
    }

    /**
     * <pre>
     *  소분류 코드 조회
     * </pre>
     * 
     * @param 선택한 대분류 코드
     * @return 선택한 대분류 코드 하위 소분류 코드
     */
    @Override
    @Transactional(readOnly = true)
    public List<CodeCdDTO> findCodeCd(String clsCd) {

        return mapper.selectCodeCd(clsCd);
    }

    /**
     * <pre>
     *  공통 코드 저장 (추가, 수정)
     * </pre>
     * 
     * @param  추가, 수정할 공통 코드 정보
     */
    @Override
    public void saveCommCd(CommCdDTO dto) {
        
        ClsCdDTO master = dto.getClsCdDTO();
        List<CodeCdDTO> detail = dto.getCodeCdDTOList();
        
        // 대분류 
        if(master != null) {
            if("C".equals(master.getStatus())) {
                mapper.insertClsCd(master);
            } else if("U".equals(master.getStatus())) {
                mapper.updateClsCd(master);
                if ("N".equals(master.getUseYn())) {
                    mapper.updateClsCodeCd(master);
                }
            } 
        }
        // 소분류
        if(detail != null) {
            for (CodeCdDTO codeCdDTO : detail) {
                if("C".equals(codeCdDTO.getStatus())) {
                    mapper.insertCodeCd(codeCdDTO);
                } else if("U".equals(codeCdDTO.getStatus())) {
                    mapper.updateCodeCd(codeCdDTO);
                }
            }
        }
        
    }

    /**
     * <pre>
     *  소분류 코드 사용 여부 일괄 수정
     * </pre>
     * 
     * @param  수정할 소분류 코드 정보
     */
    @Override
    public void editCodeCd(List<CodeCdDTO> list) {
        for (CodeCdDTO dto : list) {
            mapper.updateCodeCdUseYn(dto);
        }
    }

}
