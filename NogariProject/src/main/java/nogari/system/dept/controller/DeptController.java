package nogari.system.dept.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.dept.domain.dto.DeptReqDTO;
import nogari.system.dept.domain.dto.DeptResDTO;
import nogari.system.dept.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DeptController {
    private final DeptService service;

    @GetMapping("/depts/{deptCd}")
    public ResponseEntity<DeptResDTO> findById(@NotNull @PathVariable String deptCd){
        DeptResDTO dto = service.findOne(deptCd);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping("/dept")
    public ResponseEntity<DeptResDTO> saveDept(@Valid @RequestBody DeptReqDTO reqDTO) {
        log.info("{}", this.getClass().getSimpleName());
        service.saveDept(reqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
