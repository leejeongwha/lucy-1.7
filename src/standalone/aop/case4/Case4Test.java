package aop.case4;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aop/case4/applicationContext.xml")
public class Case4Test {
	@Autowired
	private Case4Clz6 case4Clz6;
	
	@Test
	public void testCase1() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public * *(..))");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}

	@Test
	public void testCase2() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* set*(..))");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase3() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* aop.case4.Case4Clz1.*(..))");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase4() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* aop.case4.*.*(..))");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase5() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* aop..*.*(..))");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase6() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("within(aop.case4.*)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase7() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("within(aop..*)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase8() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("this(aop.case4.Case4Clz1)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase9() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("target(aop.case4.Case4Clz1)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz1.class) && pointcut.getMethodMatcher().matches(Case4Clz1.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase10() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("args(java.lang.String)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz2.class) && pointcut.getMethodMatcher().matches(Case4Clz2.class.getMethod("set", String.class), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase11() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("@target(org.springframework.transaction.annotation.Transactional)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz3.class) && pointcut.getMethodMatcher().matches(Case4Clz3.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase12() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("@within(org.springframework.stereotype.Controller)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz4.class) && pointcut.getMethodMatcher().matches(Case4Clz4.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase13() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("@annotation(org.springframework.transaction.annotation.Transactional)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz3.class) && pointcut.getMethodMatcher().matches(Case4Clz3.class.getMethod("set"), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase14() throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("@args(org.springframework.web.bind.annotation.RequestParam)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Case4Clz5.class) && pointcut.getMethodMatcher().matches(Case4Clz5.class.getMethod("set", String.class), null), CoreMatchers.is(true));
	}
	
	@Test
	public void testCase15() throws Exception {
		case4Clz6.set("test");
	}
}
