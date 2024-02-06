package nogari.system.menu.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class MenuDTO  implements Serializable {

             public String menuCd;
             public String menuNm;
             public String sort;
             public String upperMenuCd;
             public String url;
             public String useYn;
             public String crtYn;
             public String redYn;
             public String savYn;
             public String delYn;
             public String prtYn;
             public String exlYn;
             public String etc1Yn;
             public String etc2Yn;
             public String etc3Yn;
             public String param;
             public String regId;
             public String regDt;
             public String updId;
             public String updDt;

             List<MenuDTO> list;

}
