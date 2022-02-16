package org.springframework.debugger.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.debugger.tx.dao.MessageDao;
import org.springframework.debugger.tx.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-15
 */
@Service
public class MessageService {

	@Autowired
	private MessageDao messageDao;

	public void print(int id) {
		System.out.println(messageDao.select(id));
	}

	@Transactional(propagation = Propagation.NEVER)
	public void fun1() {
//		try {
			messageDao.update(new Message(1, "测试事务", 1));
			fun2();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Transactional(propagation = Propagation.NESTED)
	public void fun2() {
		messageDao.update(new Message(1, "测试事务", 2));
		throw new RuntimeException("模拟程序异常...");
	}
}
