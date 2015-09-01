package aop.case3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.case3.TargetBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aop/case3/applicationContext.xml")
public class AopCase3 {
	private Logger logger = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private TargetBean targetBean;
	
	@Test
	public void testCase() {
		logger.info(targetBean.getMessage());
	}
}
