package nogari.system.dept.controller;

import lombok.RequiredArgsConstructor;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptRespDTO;
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
     * @return List
     */
    @GetMapping("")
    public List<DeptReqDTO> deptList(){
        return deptService.findDepts();
    }

    /**
     * 부서코드를 기준으로 부서 단건 조회
     */
    @GetMapping("/{deptCd}")
    public DeptRespDTO deptDetail(@PathVariable String deptCd){
        return deptService.findDeptByDeptCd(deptCd);
    }

    /**
     * 부서 추가
     */
    @PostMapping("")
    public void deptAdd(DeptReqDTO deptReqDto){
        deptService.createDept(deptReqDto);
    }

    /**
     * 부서 정보 수정
     */
    @PutMapping("/{deptCd}")
    public void deptModify(@PathVariable String deptCd, @RequestBody DeptReqDTO deptReqDto){
        deptService.editDept(deptReqDto);
    }

    /**
     * 부서 정보 삭제
     */
    @DeleteMapping("/{deptCd}")
    public void deptRemove(@PathVariable String deptCd){
        deptService.deleteDept(deptCd);
    }


}
