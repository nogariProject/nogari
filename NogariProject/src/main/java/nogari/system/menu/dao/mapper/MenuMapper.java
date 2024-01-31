package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> selectMenuList(@Param("menuCd") String menuCd, @Param("menuNm") String menuNm);
    List<MenuDTO> selectScreen(String menuCd);
    int insertMenu(MenuDTO menuDTO);
    int updateMenu(MenuDTO menu);
    int deleteMenu(String menuCd);

}
