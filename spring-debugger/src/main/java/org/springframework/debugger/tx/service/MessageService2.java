package org.springframework.debugger.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.debugger.tx.dao.MessageDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1. 同一个类, 两个方法
 * 		fun1 调用 fun2(有事务), fun2 异常: 没有回滚, 事务失效
 * 		fun1(有事务) 调用 fun2, fun2 异常: 事务生效
 */
@Service
public class MessageService2 {

	@Autowired
	private MessageDao messageDao;

	public void print(int id) {
		System.out.println(messageDao.select(id));
	}

	public void fun1() {
		messageDao.insert("不同类, 内层无事务");
		throw new RuntimeException("模拟程序异常...");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void fun3() {
		messageDao.insert("不同类, 内层有事务");
	}

	@Transactional
	public void fun2() {
		messageDao.insert("[内层]不同类, 外层无事务, 内层有事务: 内层会回滚");
	}

	@Transactional(propagation = Propagation.NESTED)
	public void fun4() {
		messageDao.insert("不同类, 内层有事务");
	}
}
