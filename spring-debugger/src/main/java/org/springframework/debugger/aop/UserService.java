package org.springframework.debugger.aop;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class UserService {

    public void add() {
        System.out.println("=========== 新增用户 ===========");
    }

    public void delete() {
        System.out.println("=========== 删除用户 ===========");
    }

    public void update() {
        System.out.println("=========== 更新用户 ===========");
    }
}
