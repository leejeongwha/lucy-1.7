package aop.case2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aop/case2/applicationContext.xml")
public class AopCase2 {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TargetBean targetBean;
	
	@Test
	public void testCase() {
		logger.info(targetBean.getMessage());
	}
}
