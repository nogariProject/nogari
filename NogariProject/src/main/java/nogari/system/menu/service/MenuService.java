package nogari.system.menu.service;
import nogari.system.menu.domain.dto.MenuDTO;

import java.util.List;

public interface MenuService {
    List<MenuDTO> findMenu(String menuCd, String menuNm);
    List<MenuDTO> findMenuByCd(String menuCd);
    void createMenu(List<MenuDTO> list);
    void editMenu(List<MenuDTO> list);
    void deleteMenu(String menuCd);
}
