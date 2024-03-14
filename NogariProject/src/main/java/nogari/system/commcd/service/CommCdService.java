package nogari.system.commcd.service;

import java.util.List;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.domain.dto.CommCdDTO;

public interface CommCdService {

    /**
     * <pre>
     *  대분류 코드 조회
     * </pre>
     * 
     * @param 검색을 위해 입력받은 문자열
     * @return 조회조건에 맞는 대분류 코드
     */
    List<ClsCdDTO> findClsCd(String clsCd);

    /**
     * <pre>
     *  소분류 코드 조회
     * </pre>
     * 
     * @param 선택한 대분류 코드
     * @return 선택한 대분류 코드 하위 소분류 코드
     */
    List<CodeCdDTO> findCodeCd(String clsCd);
    
    /**
     * <pre>
     *  공통 코드 저장 (추가, 수정)
     * </pre>
     * 
     * @param  추가, 수정할 공통 코드 정보
     */
    void saveCommCd(CommCdDTO dto);

    /**
     * <pre>
     *  소분류 코드 사용 여부 일괄 수정
     * </pre>
     * 
     * @param  수정할 소분류 코드 정보
     */
    void editCodeCd(List<CodeCdDTO> list);

}
