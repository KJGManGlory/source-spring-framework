package org.springframework.debugger.tx.entity;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
public class Message {

    private int id;
    private String msg;
    private int version;

	public Message() {
	}

	public Message(int id, String msg, int version) {
		this.id = id;
		this.msg = msg;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", msg='" + msg + '\'' +
				", version=" + version +
				'}';
	}
}
