package nogari.system.menu.service;

import lombok.RequiredArgsConstructor;
import nogari.system.menu.dao.mapper.MenuMapper;
import nogari.system.menu.domain.dto.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuMapper menuMapper;

    @Override
    public List<MenuDTO> getMenuList(MenuDTO menuDTO) throws Exception {
        return menuMapper.getMenuList(menuDTO);
    }
}
