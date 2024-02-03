package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuDtlDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    List<MenuDtlDTO> selectMenuList();
    List<MenuDtlDTO> selectScreen(String menuCd);
    int insertMenu(MenuDtlDTO menuDTO);
    // 다수의 Menu 객체를 받아들이도록 추가
    int updateMenu(MenuDtlDTO menuDTO);
    int deleteMenu(MenuDtlDTO menuDTO);
}
