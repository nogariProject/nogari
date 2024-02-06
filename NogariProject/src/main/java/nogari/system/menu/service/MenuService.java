package nogari.system.menu.service;

import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;

import java.util.List;

public interface MenuService {
    List<MenuFieldDTO> findMenu();
    List<MenuFieldDTO> findMenuByCd(String menuCd);
    int createMenu(MenuDTO menuDTO);
    int editMenu(MenuDTO menuDTO);
    int deleteMenu(MenuDTO menuDTO);
}
