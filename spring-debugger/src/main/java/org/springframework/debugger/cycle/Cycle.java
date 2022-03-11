package org.springframework.debugger.cycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环依赖
 */
public class Cycle {

	@Test
	public void test1() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("cycle/beans.xml");
		A a = context.getBean("a", A.class);
		B b = context.getBean("b", B.class);
		System.out.println("A: " + a + ", B: " + b);
	}

	@Test
	public void test2() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("cycle/c.xml");
		C c = context.getBean("c", C.class);
		System.out.println(c);
	}
}
