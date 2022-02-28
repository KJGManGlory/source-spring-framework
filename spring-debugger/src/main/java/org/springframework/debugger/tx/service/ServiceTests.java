package org.springframework.debugger.tx.service;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.debugger.tx.config.SpringConfig;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
public class ServiceTests {

	private MessageService messageService = new AnnotationConfigApplicationContext(SpringConfig.class)
			.getBean("messageService", MessageService.class);

	@Test
	public void test1() {
		try {
			messageService.fun1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test2() {
		try {
			messageService.fun3();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test3() {
		try {
			messageService.fun4();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test4() {
		try {
			messageService.fun6();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test5() {
		try {
			messageService.fun12();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
