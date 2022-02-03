package com.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Aspect 역할을 할 클래스라고 명시한다.
public class LogAop {
	
	//Pointcut이라고 명시된 메서드가 필요하다.
	//@Pointcut의 속성에 핵심코드의 어느 부분까지 공통기능을 사용하겠다고 명시
//	@Pointcut("within(com.aop.*)")
//	private void pointcutMethod() {
//		
//	}
	
	@Around("within(com.common.aop.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		

		String str = joinpoint.getSignature().toShortString();
		System.out.println(str + "시작");
		
		System.err.println("핵심기능 전 공통 기능"+System.currentTimeMillis());
		
		
		try {
			Object obj =  joinpoint.proceed();
			return obj;
		} finally {
			// TODO: handle exception
			System.err.println("핵심기능 후 공통 기능"+System.currentTimeMillis());
			System.out.println(str+"끝");
		}
	}
	
	
	@Before("within(com.common.aop.*)")
	public void beforeMethod() {
		System.out.println("before메소드 실행");
	}
}
