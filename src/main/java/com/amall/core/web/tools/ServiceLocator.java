package com.amall.core.web.tools;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ServiceLocator implements BeanFactoryAware {
	
	private static BeanFactory beanFactory = null;

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		beanFactory = factory;
	}

	public static Object getBean(String beanName) {
		if (beanFactory != null)
			return beanFactory.getBean(beanName);

		return null;
	}

	public static Object getDao(String daoName) {
		return getBean(daoName);
	}

	public static Object getService(String serviceName) {
		return getBean(serviceName);
	}
}
