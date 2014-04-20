package aop.case1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopAdvisor implements MethodInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try {
			logger.info("AopAdvisor:before");

			Object rtn = invocation.proceed();

			logger.info("AopAdvisor:after");

			return rtn;
		} finally {
			logger.info("AopAdvisor:afterReturning");
		}
	}

}
