package org.springframework.debugger.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-11
 */
public class Tests {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/beans.xml");
		UserService userService = context.getBean("userService", UserService.class);
		userService.add();
	}
}
