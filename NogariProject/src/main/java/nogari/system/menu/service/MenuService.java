package nogari.system.menu.service;

import nogari.system.menu.domain.dto.MenuDTO;

import java.util.List;

public interface MenuService {
    List<MenuDTO> getMenuList(MenuDTO menuDTO) throws Exception;
}
