package nogari.system.dept.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.domain.dto.DeptDTO;
import nogari.system.dept.service.DeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    /**
     * 부서 전체 리스트 조회
     *
     * @return List
     */
    @GetMapping("")
    public List<DeptDTO> deptList() {
        return deptService.findDepts();
    }

    /**
     * 부서코드를 기준으로 부서 단건 조회
     *
     * @param deptCd
     * @return
     */
    @GetMapping("/{deptCd}")
    public DeptDTO deptDetail(@PathVariable String deptCd) {
        return deptService.findDeptByDeptCd(deptCd);
    }

    /**
     * 부서 추가
     *
     * @param deptDto
     */
    @PostMapping("")
    public void deptAdd(DeptDTO deptDto) {
        deptService.createDept(deptDto);
    }

    /**
     * 부서 정보 수정
     *
     * @param deptCd
     * @param deptDto
     */
    @PutMapping("/{deptCd}")
    public void deptModify(@PathVariable String deptCd, @RequestBody DeptDTO deptDto) {
        deptService.editDept(deptDto);
    }

    /**
     * 부서 정보 삭제
     *
     * @param deptCd
     */
    @DeleteMapping("")
    public void deptRemove(@PathVariable String deptCd) {
        deptService.deleteDept(deptCd);
    }


}
