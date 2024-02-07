package nogari.system.menu.dao.mapper;

import nogari.system.menu.domain.dto.MenuFieldDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuFieldDTO> selectMenuList();				// 메뉴조회
    List<MenuFieldDTO> selectScreen(String menuCd);		// 화면조회
    int insertScreen(MenuFieldDTO menuDTO);				// 저장
    int updateMenu(MenuFieldDTO menuDTO);				// 수정
    int deleteMenu(MenuFieldDTO menuDTO);				// 삭제
}
