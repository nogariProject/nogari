package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    List<MenuDTO> selectMenuList();
    List<MenuDTO> selectScreen(String menuCd);
    void insertMenu(MenuDTO.Menu menuDTO);
    int updateMenu(MenuDTO.Menu menu);
    int deleteMenu(MenuDTO.Menu menuDTO);

}
