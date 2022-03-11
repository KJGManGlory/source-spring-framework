package org.springframework.debugger.cycle;

/**
 * 测试自己注入自己
 */
public class C {

	private C c;

	public C() {}

	public C(C c) {
		this.c = c;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}
}
