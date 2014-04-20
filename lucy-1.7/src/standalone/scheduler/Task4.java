package scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Task4 extends QuartzJobBean {
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		System.out.println("test2 : " + System.currentTimeMillis());
	}
}