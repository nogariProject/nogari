package nogari.system.commcd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import nogari.system.commcd.dao.mapper.CommCdMapper;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

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
     *  대분류 코드 저장
     * </pre>
     * 
     * @param 저장할 대분류 코드 정보
     */
    @Override
    public void createClsCd(ClsCdDTO dto) {
        mapper.insertClsCd(dto);
    }

    /**
     * <pre>
     *  소분류 코드 저장
     * </pre>
     * 
     * @param 저장할 소분류 코드 정보
     */
    @Override
    public void createCodeCd(List<CodeCdDTO> list) {
        for (CodeCdDTO dto : list) {
            mapper.insertCodeCd(dto);
        }
    }

    /**
     * <pre>
     *  대분류 코드 수정
     * </pre>
     * 
     * @param 수정한 대분류 코드 정보
     */
    @Override
    public void editClsCd(ClsCdDTO dto) {
        mapper.updateClsCd(dto);
        if (dto.getUseYN().equals("N")) {
            mapper.updateClsCodeCd(dto);
        }
    }

    /**
     * <pre>
     *  소분류 코드 수정
     * </pre>
     * 
     * @param 수정한 소분류 코드 정보
     */
    @Override
    public void editCodeCd(List<CodeCdDTO> list) {
        for (CodeCdDTO dto : list) {
            mapper.updateCodeCd(dto);
        }
    }

}
