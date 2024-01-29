package nogari.global.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;
import nogari.global.error.DTO.ErrorLogDTO;
import nogari.global.error.service.ErrorLogService;

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
	
	@Autowired
	ErrorLogService errorLogService;
	
	@Pointcut("@within(org.springframework.web.bind.annotation.RestControllerAdvice)")
	private void exceptionLogPoint() {}	// @RestControllerAdvice 어노테이션이 붙은 클래스
	
	@AfterReturning("exceptionLogPoint()")
	public void beforException(JoinPoint joinpoint) {
		
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		log.info("@@@@@@ 발생Exception :: " + signature.getName());
		log.info("@@@@@@ 발생Controller :: "  + request.getRequestURI());
		log.info("@@@@@@ 발생getQueryString :: "  + request.getQueryString());
		
		ErrorLogDTO edto = new ErrorLogDTO("", request.getRequestURL().toString(), "", signature.getName(), "001", "testErrorMessage", "홍길동");
		
		errorLogService.saveError(edto);
		
		log.info("로그저장 완료");
		
//		log.info("beforException :: "+ joinpoint.toString());
//		List<Map<String, Object>> list = errorLogService.selectTest();
//		log.info("tableList :: "+ list.toString());
	}
}
