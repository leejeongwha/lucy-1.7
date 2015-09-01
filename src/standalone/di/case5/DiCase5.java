package di.case5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/di/case5/applicationContext.xml")
public class DiCase5 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testCase5SingletonInPrototype() {
		logger.info("testCase5SingletonInPrototype");
		for(int i = 0; i < 10; i++) {
			ControllerClz controllerClz = (ControllerClz) applicationContext.getBean("controllerClz");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case1() {
		logger.info("testCase5Case1");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase1 controllerClz = (ControllerClzCase1) applicationContext.getBean("controllerClzCase1");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case2() {
		logger.info("testCase5Case2");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase2 controllerClz = (ControllerClzCase2) applicationContext.getBean("controllerClzCase2");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case3() {
		logger.info("testCase5Case3");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase3 controllerClz = (ControllerClzCase3) applicationContext.getBean("controllerClzCase3");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case4() {
		logger.info("testCase5Case4");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase4 controllerClz = (ControllerClzCase4) applicationContext.getBean("controllerClzCase4");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case5() {
		logger.info("testCase5Case5");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase5 controllerClz = (ControllerClzCase5) applicationContext.getBean("controllerClzCase5");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}
	
	@Test
	public void testCase5Case6() {
		logger.info("testCase5Case6");
		for(int i = 0; i < 10; i++) {
			ControllerClzCase6 controllerClz = (ControllerClzCase6) applicationContext.getBean("controllerClzCase6");
			logger.info(controllerClz + " : " + controllerClz.getServiceClz());
		}
	}

}
