package org.springframework.debugger.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.debugger.tx.entity.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
@Repository
public class MessageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(Message message) {
        return jdbcTemplate.update("insert into message (msg, version) values (?, ?)", message.getMsg(), message.getVersion());
    }

    public int delete(int id) {
        return jdbcTemplate.update("delete from message where id = ?", id);
    }

    public int update(Message message) {
        return jdbcTemplate.update("update message set msg = ?, version = ? where id = ?", message.getMsg(), message.getVersion(), message.getId());
    }

    public Message select(int id) {
		List<Message> result = jdbcTemplate.query("select * from message where id = " + id, (rs, num) -> {
			Message message = new Message();
			message.setId(rs.getInt(1));
			message.setMsg(rs.getString(2));
			message.setVersion(rs.getInt(3));
			return message;
		});
		return result.get(0);
    }

    public List<Message> list() {
        return jdbcTemplate.query("select * from message", new BeanPropertyRowMapper<>(Message.class));
    }
}
