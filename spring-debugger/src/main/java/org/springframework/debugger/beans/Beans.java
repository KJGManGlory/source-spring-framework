package org.springframework.debugger.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-08
 */
public class Beans {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans/beans-${user}.xml");
		User user = context.getBean("user", User.class);
		System.out.println(">>>>>> " + user.getName());
	}

	/**
	 * 验证设置属性值校验功能, 该示例设置了 abc 为必须要设置的属性, 因此容器启动时会去
	 * Environment 中寻找, 找不到报错:
	 * The following properties were declared as required but could not be resolved: [abc]
	 */
	@Test
	public void test2() {
		ApplicationContext context = new CustomClassPathXmlApplicationContext("classpath:beans/beans-${user}.xml");
		User user = context.getBean("user", User.class);
		System.out.println(">>>>>> " + user.getName());
	}
}
