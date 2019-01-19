/**
 * 
 */
package com.albums.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author ravitejakommalapati
 *
 */
@Aspect
@Component
public class LogginAspect {
Logger logger = LoggerFactory.getLogger(LogginAspect.class);
	
	@Before("execution(* com.albums..*..*(..))")
	public void logBefore(JoinPoint joinPoint) throws Throwable {
		logger.info("Entered class"+joinPoint.getTarget().getClass().getName()+"--Method Name :-"+joinPoint.getSignature().getName());
	}
	
	
	@After("execution(* com.albums..*..*(..))")
	public void logAfter(JoinPoint joinPoint) throws Throwable {
		logger.info("Exit class"+joinPoint.getTarget().getClass().getName()+"--Method Name :-"+joinPoint.getSignature().getName());
	 

	}
}
