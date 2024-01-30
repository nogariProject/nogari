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
    @GetMapping("")
    public List<DeptDTO> deptList(){
        return deptService.findDepts();
    }
    @GetMapping("{deptCd}")
    public DeptDTO deptDetail(@PathVariable String deptCd){
        return deptService.findDeptByDeptCd(deptCd);
    }
    @PostMapping("")
    public void deptAdd(DeptDTO deptDto){
        deptService.createDept(deptDto);
    }
    @PutMapping("/{deptCd}")
    public void deptModify(@PathVariable String deptCd, @RequestBody DeptDTO deptDto){
        deptService.editDept(deptDto);
    }
    @DeleteMapping
    public void deptRemove(@PathVariable String deptCd){
        deptService.deleteDept(deptCd);
    }


}
