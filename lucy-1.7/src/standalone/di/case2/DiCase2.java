package di.case2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import di.case2.ControllerClz;
import di.case2.ServiceClz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/di/case2/applicationContext.xml")
public class DiCase2 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ServiceClz serviceClz;
	
	@Autowired
	private ControllerClz controllerClz;
	
	@Test
	public void testCase2Register() {
		logger.info("" + serviceClz);
	}

	@Test
	public void testCase2Injection() {
		logger.info("" + controllerClz);
		logger.info("" + controllerClz.getServiceClz());
	}

}
