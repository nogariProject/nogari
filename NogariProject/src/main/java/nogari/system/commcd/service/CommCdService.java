package nogari.system.commcd.service;

import java.util.List;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

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
     *  대분류 코드 저장
     * </pre>
     * 
     * @param 저장할 대분류 코드 정보
     */
    void createClsCd(ClsCdDTO dto);

    /**
     * <pre>
     *  소분류 코드 저장
     * </pre>
     * 
     * @param 저장할 소분류 코드 정보
     */
    void createCodeCd(List<CodeCdDTO> list);

    /**
     * <pre>
     *  대분류 코드 수정
     * </pre>
     * 
     * @param 수정한 대분류 코드 정보
     */
    void editClsCd(ClsCdDTO dto);

    /**
     * <pre>
     *  소분류 코드 수정
     * </pre>
     * 
     * @param 수정한 소분류 코드 정보
     */
    void editCodeCd(List<CodeCdDTO> list);

}
