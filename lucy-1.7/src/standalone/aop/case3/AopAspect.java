package aop.case3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AopAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* aop.case3..*.*(..))")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect:before");
	}
	
	@After("pointcut()")
	public void after(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect:after");
	}

}
