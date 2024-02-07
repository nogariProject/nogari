package nogari.system.menu.domain.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MenuValidator.class)
public @interface MenuValidation {
    String message() default "menuCd and url cannot both be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}