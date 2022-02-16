package org.springframework.debugger.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.debugger.tx.config.SpringConfig;
import org.springframework.debugger.tx.dao.MessageDao;
import org.springframework.debugger.tx.entity.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MessageServiceTest {

    @Autowired
    private MessageDao messageDao;

	@Test
	public void test1() {
		Message message = messageDao.select(1);
		System.out.println(message);
	}
}
