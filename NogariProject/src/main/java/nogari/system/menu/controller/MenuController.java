package nogari.system.menu.controller;

import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.domain.dto.MenuDtlDTO;
import nogari.system.menu.domain.dto.MenuMstDTO;
import nogari.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@Slf4j
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public List<MenuDtlDTO> menuList() {
        return menuService.findMenu();
    }

    @GetMapping("/{menuCd}")
    public List<MenuDtlDTO> menuDetail(@PathVariable String menuCd) {
        return menuService.findMenuByCd(menuCd);
    }

    @PostMapping
    public String menuSave(@RequestBody MenuMstDTO menuMstDTO) {
        menuService.createMenu(menuMstDTO);
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
    public String sample(@RequestBody MenuDtlDTO menuDTO) {
//        log.info("getMaster:: {}",menuDTO.getMaster());
//        log.info("getDetail:: {}",menuDTO.getDetail());
        return null;
    }
}

