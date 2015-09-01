package scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Task3 extends QuartzJobBean {
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		System.out.println("test1 : " + System.currentTimeMillis());
	}
}