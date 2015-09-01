package aop.case2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TargetBean {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public String getMessage() {
		logger.info("TargetBean:getMessage");
		return "message";
	}
	
}
