package org.springframework.debugger.cycle;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-08
 */
public class A {

	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
