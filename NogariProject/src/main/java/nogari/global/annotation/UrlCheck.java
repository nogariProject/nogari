package nogari.global.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 메뉴 - MENU_CD 화면에서 생성, URL컬럼값 X
 * 화면 - MENU_CD 쿼리에서 생성, URL컬럼값 O(필수)
 * 
 * 메뉴, 화면 데이터가 하나의 테이블에 저장되므로 URL컬럼의 유무로 메뉴와 화면을 구분한다.
 * 따라서 URL컬럼값 검증 벨리데이션이 필요
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidator.class)
@Documented
public @interface UrlCheck {
	
	String message() default "URL값을 확인해주세요.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}


