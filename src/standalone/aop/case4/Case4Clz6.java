package aop.case4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Case4Clz6 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void set(String args) {
		logger.info("Case4Clz6:set");
	}
}
