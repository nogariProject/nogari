package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> getMenuList(MenuDTO menuDTO);
}
