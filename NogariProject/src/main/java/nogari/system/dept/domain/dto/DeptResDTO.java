package nogari.system.dept.domain.dto;

import lombok.Getter;
import lombok.ToString;
import oracle.sql.DATE;

import java.io.Serializable;

@Getter
@ToString
public class DeptResDTO implements Serializable {
    private String deptCd;
    private String deptNm;
    private String mgrId;
    private String upperDeptCd;
    private String sort;
    private String expDt;
    private DATE regDt;
    private String regId;
    private DATE updDt;
    private String updId;
}
