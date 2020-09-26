package com.kuake.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Hao
 * @date: 2019年4月10日 下午3:53:42 
 * @Description: 切面类
 */
@Aspect
public class LogAdvice {
	@Pointcut(value="execution(public int com.kuake.aop.Machine.*(..))")
	public void pointcut(){
	}
	
	@Before(value = "pointcut()")
	public void logBefore(){
		System.out.println("logBefore....");
	}
	
	@After(value = "pointcut()")
	public void logAfter(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"logAfter....");
	}
	
	@AfterReturning(value="pointcut()",returning="result")
	public void logReturn(Object result){
		System.out.println("logReturn....返回值"+result);
	}
	
	@AfterThrowing(value="pointcut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println(joinPoint.getSignature().getName()+"logException...."+exception);
	}
	
	@Around(value="pointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("logAround....");
        //目标方法执行的返回值
		Object proceed = joinPoint.proceed();
        System.out.println("logAround....");
		return proceed;
	}


}
