package nogari.system.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.service.MenuService;

@RestController
@RequestMapping("/menus")
@Slf4j
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public List<MenuDTO> menuList() {
        return menuService.findMenu();
    }

    @GetMapping("/{menuCd}")
    public List<MenuDTO> menuDetail(@PathVariable String menuCd) {
        return menuService.findMenuByCd(menuCd);
    }

    @PostMapping
    public String menuSave(@RequestBody MenuDTO menuDTO) {
        log.info("getMaster:: {}",menuDTO.getMaster());
        log.info("getDetail:: {}",menuDTO.getDetail());
        if(menuDTO.getMaster() == null) {
            log.info("되냐ㅑㅑㅑ");
        }
        log.info("getDetail:: {}",menuDTO.getDetail());
        menuService.createMenu(menuDTO);
        return 1+"건 저장 성공!";
    }
//
//    @PutMapping
//    public String menuModify(@RequestBody List<MenuDTO> list) {
//        int cnt = menuService.editMenu(list);
//        return cnt+"건 변경 성공!";
//    }
//
//    @DeleteMapping
//    public String menuRemove(@RequestBody List<MenuDTO> list) {
//        int cnt =menuService.deleteMenu(list);
//        return cnt+"건 삭제 성공!";
//    }

    @PostMapping("/test")
    public String sample(@RequestBody MenuDTO menuDTO) {
        log.info("getMaster:: {}",menuDTO.getMaster());
        log.info("getDetail:: {}",menuDTO.getDetail());
        return null;
    }
}

