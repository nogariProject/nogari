package nogari.system.menu.service;
import nogari.system.menu.domain.dto.MenuDTO;

import java.util.List;

public interface MenuService {
    List<MenuDTO> findMenu();
    List<MenuDTO> findMenuByCd(String menuCd);
    int createMenu(List<MenuDTO> list);
    int editMenu(List<MenuDTO> list);
    int deleteMenu(List<MenuDTO> list);
}
