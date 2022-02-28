package org.springframework.debugger.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.debugger.tx.dao.MessageDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1. 同一个类, 两个方法
 * 		fun1 调用 fun2(有事务), fun2 异常: 没有回滚, 事务失效
 * 			分析: Spring 加载 Bean 时, 遇到 @Transactional 注解, 会生成对应的代理类
 * 			但是直接调用没有 @Transactional 直接的 fun1 时, 运行的其实是 fun1 的原始
 * 			代码, 而非代理后的, 所以 fun1 调用的也是原始 fun2
 * 		fun1(有事务) 调用 fun2, fun2 异常: 事务回滚
 * 			分析: fun1 有事务之后, 调用时便是调用代理后的代码
 * 2. 不同类, 两个方法
 * 		fun1 调用 fun2(有事务), fun2 异常: 事务回滚
 *		fun1(有事务) 调用 fun2, fun2 异常: 事务回滚
 */
@Service
public class MessageService {

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private MessageService2 messageService2;

	public void print(int id) {
		System.out.println(messageDao.select(id));
	}

	// 同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚
	public void fun1() {
		messageDao.insert("同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚");
		fun2();
	}

	@Transactional
	public void fun2() {
		messageDao.insert("同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚");
		throw new RuntimeException("模拟程序异常...");
	}

	// 不同类, 外层无事务, 内层有事务: 内层会回滚
	public void fun3() {
		messageDao.insert("[外层]不同类, 外层无事务, 内层有事务: 内层会回滚");
		messageService2.fun2();
		throw new RuntimeException("模拟程序异常...");
	}

	// 同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚
	public void fun4() {
		messageDao.insert("同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚");
		fun5();
	}

	@Transactional(propagation = Propagation.NESTED)
	public void fun5() {
		messageDao.insert("同一个类, 外层无事务, 内层有事务: 两个操作都不会回滚");
		throw new RuntimeException("模拟程序异常...");
	}

	@Transactional
	public void fun6() {
		messageDao.insert("同一个类, 外层有事务, 内层无事务: 两个操作都会回滚");
		messageService2.fun1();
	}

	public void fun7() {
		messageDao.insert("同一个类, 外层无事务, 内层有事务: 两个操作都会回滚");
		throw new RuntimeException("模拟程序异常...");
	}

	@Transactional
	public void fun8() {
		messageDao.insert("同一个类, 外层");
		fun9();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void fun9() {
		messageDao.insert("同一个类, 内层");
		throw new RuntimeException("模拟程序异常...");
	}

	@Transactional
	public void fun10() {
		messageDao.insert("同一个类, 外层");
		messageService2.fun3();
	}

	@Transactional
	public void fun11() {
		messageDao.insert("同一个类, 外层");
		messageService2.fun3();
		throw new RuntimeException("模拟程序异常...");
	}

	@Transactional
	public void fun12() {
		messageDao.insert("不同类, 外层");
		messageService2.fun4();
		throw new RuntimeException("模拟程序异常...");
	}
}
