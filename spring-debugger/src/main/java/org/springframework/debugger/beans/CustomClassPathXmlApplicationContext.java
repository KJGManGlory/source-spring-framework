package org.springframework.debugger.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-10
 */
public class CustomClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public CustomClassPathXmlApplicationContext(String... locations) {
		super(locations);
	}

	@Override
	protected void initPropertySources() {
		getEnvironment().setRequiredProperties("user");
	}
}
