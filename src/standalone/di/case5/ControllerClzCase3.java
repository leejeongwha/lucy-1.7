package di.case5;

import org.springframework.beans.factory.ObjectFactory;

public class ControllerClzCase3 {
	private ObjectFactory<ServiceClz> objectFactory;

	public ObjectFactory<ServiceClz> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<ServiceClz> objectFactory) {
		this.objectFactory = objectFactory;
	}

	public ServiceClz getServiceClz() {
		return objectFactory.getObject();
	}

}
