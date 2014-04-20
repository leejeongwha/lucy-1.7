package di.case4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/di/case4/applicationContext.xml")
public class DiCase4 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testCase4() {
		for(int i = 0; i < 10; i++) {
			ControllerClz controllerClz1 = (ControllerClz) applicationContext.getBean("controllerClz1");
			ControllerClz controllerClz2 = (ControllerClz) applicationContext.getBean("controllerClz2");
			logger.info(controllerClz1 + " : " + controllerClz2);
		}
	}

}
