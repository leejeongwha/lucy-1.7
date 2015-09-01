package aop.case2;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void before(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect:before");
	}
	
	public void after(JoinPoint joinPoint) throws Exception {
		logger.info("AopAspect:after");
	}

}
