package nogari.system.menu.service;

import nogari.system.menu.domain.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MenuService {
    List<MenuDTO> findMenu(String menuCd, String menuNm);
    MenuDTO findMenuByCd(String menuCd);
    void createMenu(MenuDTO menuDTO);
    void editMenu(MenuDTO menu);
    void deleteMenu(String menuCd);
}
