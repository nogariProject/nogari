package nogari.system.commcd.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.domain.dto.CommCdDTO;
import nogari.system.commcd.service.CommCdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 
 * @author CSPI
 */
@RestController
@RequestMapping("${api.base-path}/common-cds")
@RequiredArgsConstructor
public class CommCdController {

    private final CommCdService service;

    /**
     * <pre>
     *  대분류 코드 조회
     * </pre>
     * 
     * @param  검색을 위해 입력받은 문자열
     * @return 조회 조건에 맞는 대분류 코드
     */
    @GetMapping
    public ResponseEntity<List<ClsCdDTO>> clsCdList(@RequestParam(required = false) String clsCd) {
        List<ClsCdDTO> list = service.findClsCd(clsCd);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * <pre>
     *  소분류 코드 조회
     * </pre>
     * 
     * @param  선택한 대분류 코드
     * @return 선택한 대분류 코드 하위 소분류 코드
     */
    @GetMapping("/{clsCd}")
    public ResponseEntity<List<CodeCdDTO>> codeCdList(@PathVariable String clsCd) {
        List<CodeCdDTO> list = service.findCodeCd(clsCd);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * <pre>
     *  공통 코드 저장 (추가, 수정)
     * </pre>
     * 
     * @param  추가, 수정할 공통 코드 정보
     * @return 추가, 수정 성공 여부
     */
    @PostMapping("/{clsCd}")
    public ResponseEntity<?> commCdSave(@PathVariable String clsCd, @Valid @RequestBody CommCdDTO dto) {
        service.saveCommCd(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * <pre>
     *  소분류 코드 사용 여부 일괄 수정
     * </pre>
     * 
     * @param  수정할 소분류 코드 정보
     * @return 수정 성공 여부
     */
    @PutMapping("/{clsCd}")
    public ResponseEntity<?> codeCdModify(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) {
        service.editCodeCd(list);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
