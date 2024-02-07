package nogari.system.menu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nogari.system.menu.dao.mapper.MenuMapper;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
	
    private final MenuMapper menuMapper;

    /* 조회 */
    @Override
    public List<MenuFieldDTO> findMenu() {
        return menuMapper.selectMenuList();
    }

    @Override
    public List<MenuFieldDTO> findMenuByCd(String menuCd) {
        return menuMapper.selectScreen(menuCd);
    }
    
    /* 저장 */
    @Override
    @Transactional
    public int createMenu(MenuDTO menuDTO) {
        
        MenuFieldDTO master       = menuDTO.getMaster();
        List<MenuFieldDTO> detail = menuDTO.getDetail();
        int cnt = 0;	// 건수
        
        // 메뉴등록
        if(master != null && master.getMenuCd() != null) {
            cnt += menuMapper.insertScreen(master);
        }
        // 화면등록
        if(detail != null){
            for(MenuFieldDTO scr : detail){
                cnt += menuMapper.insertScreen(scr);
            }
        }
        
        return cnt;
    }

    /* 수정 */
    @Override
    @Transactional
    public int editMenu(MenuDTO menuDTO) {
        
        MenuFieldDTO master       = menuDTO.getMaster();
        List<MenuFieldDTO> detail = menuDTO.getDetail();
        int cnt = 0;	// 건수
        
        // 메뉴수정
        if(master != null && master.getMenuCd() != null) {			/*신규메뉴일 경우 MENU_CD가 미존재하므로 SQL에러 방지*/
            cnt += menuMapper.updateMenu(master);
        }
        // 화면수정
        if(detail != null){
            for(MenuFieldDTO scr : detail) {
            	if(scr.getMenuCd() != null) {						/*신규화면일 경우 MENU_CD가 미존재하므로 SQL에러 방지*/
                cnt += menuMapper.updateMenu(scr);
            	}
            }
        }
        return cnt;
    }

    /* 삭제 */
    @Override
    public int deleteMenu(MenuDTO menuDTO) {
        
        MenuFieldDTO master       = menuDTO.getMaster();
        List<MenuFieldDTO> detail = menuDTO.getDetail();
        int cnt = 0;	// 건수
        
        // 메뉴삭제
        if(master != null && master.getMenuCd() != null) {			/*신규메뉴일 경우 MENU_CD가 미존재하므로 SQL에러 방지*/
            cnt += menuMapper.deleteMenu(menuDTO.getMaster());
        }
        // 화면삭제
        if(detail != null){
            for(MenuFieldDTO scr : detail) {
            	if(scr.getMenuCd() != null) {						/*신규화면일 경우 MENU_CD가 미존재하므로 SQL에러 방지*/
            		cnt += menuMapper.deleteMenu(scr);
            	}                
            }
        }
        
        return cnt;
    }
}
