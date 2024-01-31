package nogari.system.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import nogari.system.menu.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	
	public String findMenus() {
		
		
		
		
		return "";
	}
	

}
