package org.springframework.debugger.factory_bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-13
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
