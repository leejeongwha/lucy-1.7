package di.case5;

public class ControllerClzCase1 {
	public ServiceClz getServiceClz() {
		return ApplicationContextHolder.getApplicationContext().getBean(
				ServiceClz.class);
	}

}
