package nogari.system.commcd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

@Mapper
public interface CommCdMapper {

    /**
     * <pre>
     *  대분류 코드 조회
     * </pre>
     * 
     * @param 검색을 위해 입력받은 문자열
     * @return 조회조건에 맞는 대분류 코드
     */
    List<ClsCdDTO> selectClsCd(String clsCd);

    /**
     * <pre>
     *  소분류 코드 조회
     * </pre>
     * 
     * @param 선택한 대분류 코드
     * @return 선택한 대분류 코드 하위 소분류 코드
     */
    List<CodeCdDTO> selectCodeCd(String clsCd);

    /**
     * <pre>
     *  대분류 코드 저장
     * </pre>
     * 
     * @param 저장할 대분류 코드 정보
     */
    void insertClsCd(ClsCdDTO dto);

    /**
     * <pre>
     *  소분류 코드 저장
     * </pre>
     * 
     * @param 저장할 소분류 코드 정보
     */
    void insertCodeCd(CodeCdDTO dto);

    /**
     * <pre>
     *  대분류 코드 수정
     * </pre>
     * 
     * @param 수정한 대분류 코드 정보
     */
    void updateClsCd(ClsCdDTO dto);

    /**
     * <pre>
     *  수정된 대분류 코드의 하위 소분류 코드 사용여부 수정
     * </pre>
     * 
     * @param 수정할 소분류 코드의 상위 대분류 코드 정보
     */
    void updateClsCodeCd(ClsCdDTO dto);

    /**
     * <pre>
     *  소분류 코드 수정
     * </pre>
     * 
     * @param 수정한 소분류 코드 정보
     */
    void updateCodeCd(CodeCdDTO dto);

}
