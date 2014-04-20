package di.case5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryHolder implements BeanFactoryAware {
	private static BeanFactory factory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		factory = beanFactory;
	}
	
	public static BeanFactory getBeanFactory() {
		return factory;
	}

}
