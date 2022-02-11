package org.springframework.debugger.beans;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-10
 */
public class EnvironmentTest {

	public static void main(String[] args){
		System.getenv().entrySet().stream().forEach(System.out::println);
		System.out.println("==========================");
		System.getProperties().entrySet().stream().forEach(System.out::println);
	}
}
