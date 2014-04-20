package scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class Task2 {
	@Scheduled(cron = "0 * * * * ?")
	public void test1() {
		System.out.println("test1 : " + System.currentTimeMillis());
	}

	@Scheduled(fixedDelay = 1000)
	public void test2() {
		System.out.println("test2 : " + System.currentTimeMillis());
	}
}
