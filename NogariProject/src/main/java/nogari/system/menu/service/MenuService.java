package nogari.system.menu.service;
import nogari.system.menu.domain.dto.MenuDtlDTO;
import nogari.system.menu.domain.dto.MenuMstDTO;

import java.util.List;

public interface MenuService {
    List<MenuDtlDTO> findMenu();
    List<MenuDtlDTO> findMenuByCd(String menuCd);
    int createMenu(MenuMstDTO menuMstDTO);
    int editMenu(MenuMstDTO menuMstDTO);
    int deleteMenu(MenuMstDTO menuMstDTO);
}
