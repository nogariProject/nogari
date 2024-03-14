package nogari.system.dept.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;
import nogari.system.dept.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base-path}/depts")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    /**
     * 부서 전체 리스트 조회
     *
     * @return List
     */
    @GetMapping("")
    public ResponseEntity<List<DeptReqDTO>> deptList() {
        List<DeptReqDTO> depts = deptService.findDepts();
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }

    /**
     * 부서코드를 기준으로 부서 단건 조회
     */
    @GetMapping("/{deptCd}")
    public ResponseEntity<DeptRespDTO> deptDetail(@PathVariable String deptCd) {
        DeptRespDTO deptByDeptCd = deptService.findDeptByDeptCd(deptCd);
        return new ResponseEntity<>(deptByDeptCd, HttpStatus.OK);
    }

    /**
     * 부서 추가
     *
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Integer> deptAdd(DeptReqDTO deptReqDto) {
        int createdRows = deptService.createDept(deptReqDto);
        return new ResponseEntity<>(createdRows, HttpStatus.OK);
    }

    /**
     * 부서 정보 수정
     *
     * @return
     */
    @PutMapping("/{deptCd}")
    public ResponseEntity<Integer> deptModify(@PathVariable String deptCd, @RequestBody DeptReqDTO deptReqDto) {
        int updatedRows = deptService.editDept(deptReqDto);
        return new ResponseEntity<>(updatedRows, HttpStatus.OK);
    }

    /**
     * 부서 정보 삭제
     *
     * @return
     */
    @DeleteMapping("/{deptCd}")
    public ResponseEntity<Integer> deptRemove(@PathVariable String deptCd) {
        int deletedRows = deptService.deleteDept(deptCd);
        return new ResponseEntity<>(deletedRows, HttpStatus.OK);
    }


}
