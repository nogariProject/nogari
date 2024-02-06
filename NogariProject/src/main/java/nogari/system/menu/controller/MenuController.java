package nogari.system.menu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;
import nogari.system.menu.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
@Slf4j
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @GetMapping
    public List<MenuFieldDTO> menuList() {
        return menuService.findMenu();
    }

    @GetMapping("/{menuCd}")
    public List<MenuFieldDTO> menuDetail(@PathVariable String menuCd) {
        return menuService.findMenuByCd(menuCd);
    }

    @PostMapping
    public String menuSave(@RequestBody MenuDTO menuDTO) {
        int cnt = menuService.createMenu(menuDTO);
        return cnt+"건 저장 성공!";
    }

    @PutMapping
    public String menuModify(@Valid @RequestBody MenuDTO menuDTO) {
        int cnt = menuService.editMenu(menuDTO);
        return cnt+"건 변경 성공!";
    }

    @DeleteMapping
    public String menuRemove(@RequestBody MenuDTO menuDTO) {
        int cnt =menuService.deleteMenu(menuDTO);
        return cnt+"건 삭제 성공!";
    }

    @PostMapping("/test")
    public String sample(@RequestBody MenuFieldDTO menuDTO) {
//        log.info("getMaster:: {}",menuDTO.getMaster());
//        log.info("getDetail:: {}",menuDTO.getDetail());
        return null;
    }
}