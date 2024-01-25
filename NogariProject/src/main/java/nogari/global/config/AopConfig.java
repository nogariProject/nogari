package nogari.global.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**  AOP용어
 *   Advice    : 적용 할 공통로직(기능)
 *   Joinpoint : Advice가 적용 될 수 있는 시점들
 * 	 Pointcut  : Joinpoint 중 Advice가 실제로 적욜 될 시점들 묶음
 *   Advisor   : Advice + Pointcut
 *   Target    : Advisor를 적용할 대상객체
 *   Aspect    : Target들에 적용 될 Advisor의 모음
 *   Proxy     : Target에 Advisor가 적용 된 후 생성 된 객체
 **/

@Aspect
@Component
@Slf4j
public class AopConfig {
	
	@Pointcut("@within(org.springframework.web.bind.annotation.RestControllerAdvice)")
	private void exceptionLogPoint() {}	// @RestControllerAdvice 어노테이션이 붙은 클래스
	
	@Before("exceptionLogPoint()")
	public void beforException(JoinPoint joinpoint) {
		log.info("beforException :: "+ joinpoint.toString());
	}
}
