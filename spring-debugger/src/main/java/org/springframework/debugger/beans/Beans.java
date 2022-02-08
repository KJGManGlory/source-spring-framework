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

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans/beans.xml");
		User user = context.getBean("user", User.class);
		System.out.println(user);
	}
}
