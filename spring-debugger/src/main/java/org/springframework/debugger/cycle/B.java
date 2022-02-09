package org.springframework.debugger.cycle;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-08
 */
public class B {

	private A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
}
