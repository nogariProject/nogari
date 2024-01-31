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
    @GetMapping("/list")
    public List<MenuDTO> menuList(@RequestParam(required = false) String menuCd,
                                  @RequestParam(required = false) String menuNm) {
        log.info("===================>  MenuController 진입");
        return menuService.findMenu(menuCd,menuNm);
    }

    @GetMapping("/detail")
    public List<MenuDTO> menuDetail(@RequestParam String menuCd) {
        return menuService.findMenuByCd(menuCd);
    }

    @PostMapping("/save")
    public String menuSave(@RequestBody List<MenuDTO> list) {

        menuService.createMenu(list);
        return "Menu created successfully!";
    }

    @PutMapping ("/save")
    public String menuModify(@RequestBody List<MenuDTO> list) {
        menuService.editMenu(list);
        return "Menu updated successfully!";
    }

    @DeleteMapping("/delete/{menuCd}")
    public String menuRemove(@PathVariable String menuCd) {
        menuService.deleteMenu(menuCd);
        return "Menu deleted successfully!";
    }
}

