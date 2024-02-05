package nogari.system.menu.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.dao.mapper.MenuMapper;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;
import nogari.system.menu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private MenuMapper menuMapper;

    @Override
    public List<MenuFieldDTO> findMenu() {
        return menuMapper.selectMenuList();
    }

    @Override
    public List<MenuFieldDTO> findMenuByCd(String menuCd) {
        return menuMapper.selectScreen(menuCd);
    }

    @Override
    @Transactional
    public int createMenu(MenuDTO menuDTO) {
        int cnt = 0;
        if(menuDTO.getMaster() != null) {
            cnt += menuMapper.insertScreen(menuDTO.getMaster());
        }
        if(menuDTO.getDetail() != null){
            for(MenuFieldDTO dDto : menuDTO.getDetail()){
                cnt += menuMapper.insertScreen(dDto);
            }
        }
        return cnt;
    }

    @Override
    @Transactional
    public int editMenu(MenuDTO menuDTO) {
        int cnt = 0;
        if(menuDTO.getMaster().getMenuNm() != null) {
            cnt += menuMapper.updateMenu(menuDTO.getMaster());
        }
        if(menuDTO.getDetail() != null){
            for(MenuFieldDTO dDto : menuDTO.getDetail()){
                cnt += menuMapper.updateMenu(dDto);
            }
        }
        return cnt;
    }

    @Override
    public int deleteMenu(MenuDTO menuDTO) {
        int cnt = 0;
        if(menuDTO.getMaster().getMenuNm() != null) {
            cnt += menuMapper.deleteMenu(menuDTO.getMaster());
        }
        if(menuDTO.getDetail() != null){
            for(MenuFieldDTO dDto : menuDTO.getDetail()){
                cnt += menuMapper.deleteMenu(dDto);
            }
        }
        return cnt;
    }
}
