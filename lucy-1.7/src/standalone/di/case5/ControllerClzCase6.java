package di.case5;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;

public class ControllerClzCase6 {
	@Autowired
	private Provider<ServiceClz> provider;

	public Provider<ServiceClz> getProvider() {
		return provider;
	}

	public void setProvider(Provider<ServiceClz> provider) {
		this.provider = provider;
	}

	public ServiceClz getServiceClz() {
		return provider.get();
	}

}
