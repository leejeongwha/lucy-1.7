package scheduler;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/scheduler/applicationContext5.xml")
public class SchedulerCase5 {
	
	@Test
	public void test1() throws InterruptedException {
		final SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(Long.MAX_VALUE);
					queue.put(new Object());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		queue.poll(Long.MAX_VALUE, TimeUnit.SECONDS);
	}
}
