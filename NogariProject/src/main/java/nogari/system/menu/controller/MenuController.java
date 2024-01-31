package nogari.system.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.service.MenuService;

@RestController
@RequestMapping("/menu")
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

    @PostMapping("/update")
    public String menuModify(@RequestBody MenuDTO menu) {
        menuService.editMenu(menu);
        return "Menu updated successfully!";
    }

    @GetMapping("/delete/{menuCd}")
    public String menuRemove(@PathVariable String menuCd) {
        menuService.deleteMenu(menuCd);
        return "Menu deleted successfully!";
    }
}

