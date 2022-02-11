package org.springframework.debugger.test;

import org.junit.Test;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-10
 */
public class EnvironmentTests {

	@Test
	public void test1() {
		System.out.println(System.getenv());
		System.out.println("==========================");
		System.out.println(System.getProperties());
	}
}
