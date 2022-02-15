package org.springframework.debugger.factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-13
 */
public class FactoryBeanTests {

	@Test
	public void test1() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:factory_bean/beans.xml");
		User user = context.getBean(User.class);
		user.say();
	}
}
