package di.case5;


public class ControllerClzCase4 {
	private ServiceClzFactory serviceClzFactory;

	public ServiceClzFactory getServiceClzFactory() {
		return serviceClzFactory;
	}

	public void setServiceClzFactory(ServiceClzFactory serviceClzFactory) {
		this.serviceClzFactory = serviceClzFactory;
	}

	public ServiceClz getServiceClz() {
		return serviceClzFactory.getServiceClz();
	}

}
