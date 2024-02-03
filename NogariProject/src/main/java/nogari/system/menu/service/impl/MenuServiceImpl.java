package nogari.system.menu.service.impl;

import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.dao.mapper.MenuMapper;
import nogari.system.menu.domain.dto.MenuDtlDTO;
import nogari.system.menu.domain.dto.MenuMstDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nogari.system.menu.service.MenuService;

import java.util.List;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDtlDTO> findMenu() {
        return menuMapper.selectMenuList();
    }

    @Override
    public List<MenuDtlDTO> findMenuByCd(String menuCd) {
        return menuMapper.selectScreen(menuCd);
    }

    @Override
    public int createMenu(MenuMstDTO menuMstDTO) {
        int cnt = 0;
        if(menuMstDTO.getMaster().getMenuNm() != null) {
            MenuDtlDTO menuDtlDTO = new MenuDtlDTO();
            BeanUtils.copyProperties(menuMstDTO.getMaster(),menuDtlDTO);
            cnt += menuMapper.insertMenu(menuDtlDTO);
        }
        if(menuMstDTO.getDetail() != null){
            for(MenuDtlDTO dDto : menuMstDTO.getDetail()){
                cnt += menuMapper.insertMenu(dDto);
            }
        }
        return cnt;
    }

    @Override
    public int editMenu(MenuMstDTO menuMstDTO) {
        int cnt = 0;
        if(menuMstDTO.getMaster().getMenuNm() != null) {
            MenuDtlDTO menuDtlDTO = new MenuDtlDTO();
            BeanUtils.copyProperties(menuMstDTO.getMaster(),menuDtlDTO);
            cnt += menuMapper.updateMenu(menuDtlDTO);
        }
        if(menuMstDTO.getDetail() != null){
            for(MenuDtlDTO dDto : menuMstDTO.getDetail()){
                cnt += menuMapper.updateMenu(dDto);
            }
        }
        return cnt;
    }

    @Override
    public int deleteMenu(MenuMstDTO menuMstDTO) {
        int cnt = 0;
        if(menuMstDTO.getMaster().getMenuNm() != null) {
            MenuDtlDTO menuDtlDTO = new MenuDtlDTO();
            BeanUtils.copyProperties(menuMstDTO.getMaster(),menuDtlDTO);
            cnt += menuMapper.deleteMenu(menuDtlDTO);
        }
        if(menuMstDTO.getDetail() != null){
            for(MenuDtlDTO dDto : menuMstDTO.getDetail()){
                cnt += menuMapper.deleteMenu(dDto);
            }
        }
        return cnt;
    }
}
