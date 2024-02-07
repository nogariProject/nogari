package nogari.system.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;
import nogari.system.menu.service.MenuService;

@RestController
@RequestMapping("/menus")
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
    public ResponseEntity<String> menuSave(@RequestBody @Valid MenuDTO menuDTO) {
    	
//    	if(!menuDTO.urlChk()) {
//    		return new ResponseEntity<>("url작성오류", HttpStatus.BAD_REQUEST);
//    	}
    	
        int cnt = menuService.createMenu(menuDTO);
        return new ResponseEntity<>(cnt+"건 저장 성공!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> menuModify(@Valid @RequestBody MenuDTO menuDTO) {
        int cnt = menuService.editMenu(menuDTO);
        return new ResponseEntity<>(cnt+"건 저장 성공!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> menuRemove(@RequestBody MenuDTO menuDTO) {
        int cnt = menuService.deleteMenu(menuDTO);
        return new ResponseEntity<>(cnt+"건 삭제 성공!", HttpStatus.OK);
    }

}

