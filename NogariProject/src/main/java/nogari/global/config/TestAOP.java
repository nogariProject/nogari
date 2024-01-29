package nogari.global.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {
	// @within : 클래스의 어노테이션
	// @annotation : 메소드의 어노테이션
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void contollerPointCut() {}
	
	@Before("contollerPointCut()")
	public void beforeController() {
		System.out.println("@@before Controller");
	}
	
	@After("bean(*Controller)")
	public void afterController() {
		System.out.println("@@after  Controller");
	}
	
	@Around("@within(org.springframework.web.bind.annotation.RestController)")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			System.out.println("@@around Controller start");
			return joinPoint.proceed();
		}finally {
            System.out.print("@@@@@@@@@@@@@@@@@@@\n" + getClassBuffer());
            System.out.println("@@@@@@@@@@@@@@@@@@@\n" + getMethodBuffer() + "@@@@@@@@@@@@@@@@@@@");
            
			System.out.println("@@around Controller finish");
		}
		
	}
	
	private StringBuilder classBuffer = new StringBuilder();
    private StringBuilder methodBuffer = new StringBuilder();

    @Around("execution(* nogari.sample.test.controller..*(..)) || " +
            "execution(* nogari.sample.test.service..*(..)) || " +
            "execution(* nogari.sample.test.mapper..*(..))")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
    	
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        try {
            classBuffer.append(" Class : ").append(className).append("\n");
            methodBuffer.append("Method : ").append(methodName).append("\n");
            
            Object result = joinPoint.proceed();

            return result;
        } finally {
        	
        }
    }

    // 클래스명과 메서드명을 반환하는 메서드
    public String getClassBuffer() {
        return classBuffer.toString();
    }

    public String getMethodBuffer() {
        return methodBuffer.toString();
    }
}
