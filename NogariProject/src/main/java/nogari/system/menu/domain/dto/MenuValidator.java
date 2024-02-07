package nogari.system.menu.domain.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Slf4j
@Component
public class MenuValidator implements ConstraintValidator<MenuValidation, MenuDTO> {
    @Override
    public void initialize(MenuValidation constraintAnnotation) {
        log.info("============> MenuValidator initialize");
    }

    @Override
    public boolean isValid(MenuDTO menuDTO, ConstraintValidatorContext context) {
        log.info("============> MenuValidator isValid");
        boolean isVal = true;
        // 여기에서 원하는 유효성 검사 로직을 작성
        if(menuDTO.getMaster().getMenuCd() == null &&menuDTO.getMaster().getUrl() == null ||
                menuDTO.getMaster().getMenuCd() != null &&menuDTO.getMaster().getUrl() != null){
            isVal = false;
        }
        return isVal;
    }
    @PostConstruct
    public void postConstruct() {
        log.info("===============> MenuValidator 빈이 생성되었습니다.");
    }
}
