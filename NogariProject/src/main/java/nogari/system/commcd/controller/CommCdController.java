package nogari.system.commcd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;
import nogari.system.commcd.domain.dto.CommCdDTO;
import nogari.system.commcd.service.CommCdService;

/**
 * 
 * @author CSPI
 */
@RestController
@RequestMapping("/common-cds")
@RequiredArgsConstructor
public class CommCdController {

    private final CommCdService service;

    /**
     * <pre>
     *  대분류 코드 조회
     * </pre>
     * 
     * @param 검색을 위해 입력받은 문자열
     * @return 조회조건에 맞는 대분류 코드
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
     * @param 선택한 대분류 코드
     * @return 선택한 대분류 코드 하위 소분류 코드
     */
    @GetMapping("/{clsCd}")
    public ResponseEntity<List<CodeCdDTO>> codeCdList(@PathVariable String clsCd) {
        List<CodeCdDTO> list = service.findCodeCd(clsCd);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * <pre>
     *  대분류 코드 저장
     * </pre>
     * 
     * @param 저장할 대분류 코드 정보
     * @return 저장 성공 여부
     */
    @PostMapping
    public ResponseEntity<?> clsCdAdd(@RequestBody ClsCdDTO dto) {
        service.createClsCd(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * <pre>
     *  소분류 코드 저장
     * </pre>
     * 
     * @param 저장할 소분류 코드 정보
     * @return 저장 성공 여부
     */
    @PostMapping("/{clsCd}")
    public ResponseEntity<?> codeCdAdd(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) {
        service.createCodeCd(list);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * <pre>
     *  대, 소분류 코드 동시 저장
     * </pre>
     * 
     * @param 저장할 대, 소분류 코드 정보
     * @return 저장 성공 여부
     */
    @PostMapping("/save")
    public ResponseEntity<?> commCdAdd(@RequestBody CommCdDTO dto) {
        service.createClsCd(dto.getClsCdDTO());
        service.createCodeCd(dto.getCodeCdDTOList());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * <pre>
     *  대분류 코드 수정
     * </pre>
     * 
     * @param 수정한 대분류 코드 정보
     * @return 수정 성공 여부
     */
    @PutMapping
    public ResponseEntity<?> clsCdModify(@RequestBody ClsCdDTO dto) {
        service.editClsCd(dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * <pre>
     *  소분류 코드 수정
     * </pre>
     * 
     * @param 수정한 소분류 코드 정보
     * @return 수정 성공 여부
     */
    @PutMapping("/{clsCd}")
    public ResponseEntity<?> codeCdModify(@PathVariable String clsCd, @RequestBody List<CodeCdDTO> list) {
        service.editCodeCd(list);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
