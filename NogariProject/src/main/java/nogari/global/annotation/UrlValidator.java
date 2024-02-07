package nogari.global.annotation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import nogari.system.menu.domain.dto.MenuDTO;
import nogari.system.menu.domain.dto.MenuFieldDTO;

@Component
public class UrlValidator implements ConstraintValidator<UrlCheck, MenuDTO>{

	@Override
	public boolean isValid(MenuDTO value, ConstraintValidatorContext context) {
		
		MenuFieldDTO master       = value.getMaster();
		List<MenuFieldDTO> detail = value.getDetail();
		
		// 메뉴검증
    	if(master != null && (master.getUrl() != null && !master.getUrl().equals("")) ) return false;
    	
    	// 화면검증
    	if(detail != null) {
    		for(MenuFieldDTO scr : detail) {
    			String url = scr.getUrl();
    			if(url == null || url.equals("")) return false;
    		}
    	}
		
		return true;
	}
	

}
