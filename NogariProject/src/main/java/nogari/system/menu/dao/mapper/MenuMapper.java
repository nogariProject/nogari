package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> selectMenu(@Param("menuCd") String menuCd, @Param("menuNm") String menuNm);
    MenuDTO selectMenuByCd(String menuCd);
    void insertMenu(MenuDTO menuDTO);
    void updateMenu(MenuDTO menu);
    void deleteMenu(String menuCd);

}
