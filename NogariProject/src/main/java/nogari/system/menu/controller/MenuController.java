package nogari.system.menu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {


    private final MenuService menuService;

    @GetMapping("/menus")
    public List<MenuDTO> getMenuController(MenuDTO menuDTO) throws Exception {

        System.err.println("이건가?");
        System.err.println("이건가?14123412312412431231223");

        log.info("MenuController.getMenuController {}");
        List<MenuDTO> resultList =  menuService.getMenuList(menuDTO);

        System.err.println("이건가?");
        System.err.println("이건가?");

        return resultList;

    }


}// end class
