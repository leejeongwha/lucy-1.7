package aop.case4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AopAspect1 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("bean(case4Clz6)")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect1:before");
	}
	
	@After("pointcut()")
	public void after(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect1:after");
	}

}
