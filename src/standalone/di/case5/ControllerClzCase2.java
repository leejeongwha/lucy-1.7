package di.case5;

public class ControllerClzCase2 {
	public ServiceClz getServiceClz() {
		return BeanFactoryHolder.getBeanFactory().getBean(
				ServiceClz.class);
	}

}
