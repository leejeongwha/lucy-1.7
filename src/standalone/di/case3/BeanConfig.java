package di.case3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean(name="controllerClz")
	public ControllerClz controllerClz(ServiceClz serviceClz) {
		ControllerClz controllerClz = new ControllerClz();
		controllerClz.setServiceClz(serviceClz);
		return controllerClz;
	}
	
	@Bean(name="serviceClz")
	public ServiceClz serviceClz() {
		return new ServiceClz();
	}
}
