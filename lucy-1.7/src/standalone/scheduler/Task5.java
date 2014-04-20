package scheduler;

import java.util.TimerTask;

public class Task5 extends TimerTask {
	public void run() {
		System.out.println("test1 : " + System.currentTimeMillis());
	}
}