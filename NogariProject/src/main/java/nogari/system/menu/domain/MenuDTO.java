package nogari.system.menu.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class MenuDTO {
    private String menuCd;
    private String menuNm;
    private Integer sort;
    private String upperMenuCd;
    private String url;
    private String useYn;
    private String crtYn;
    private String redYn;
    private String savYn;
    private String delYn;
    private String prtYn;
    private String exlYn;
    private String etc1Yn;
    private String etc2Yn;
    private String etc3Yn;
    private String param;
    private String regId;
    private Date regDt;
    private String updId;
    private Date updDt;

    private List<MenuDTO> menuList;

}
