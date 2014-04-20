package di.case1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/di/case1/applicationContext.xml")
public class DiCase1 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ServiceClz serviceClz;
	
	@Autowired
	private ControllerClz controllerClz;
	
	@Test
	public void testCase1Register() {
		logger.info("" + serviceClz);
	}

	@Test
	public void testCase1Injection() {
		logger.info("" + controllerClz);
		logger.info("" + controllerClz.getServiceClz());
	}

}
