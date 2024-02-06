package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuFieldDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    List<MenuFieldDTO> selectMenuList();

    List<MenuFieldDTO> selectScreen(String menuCd);

    int insertScreen(MenuFieldDTO menuDTO);

    // 다수의 Menu 객체를 받아들이도록 추가
    int updateMenu(MenuFieldDTO menuDTO);

    int deleteMenu(MenuFieldDTO menuDTO);
}