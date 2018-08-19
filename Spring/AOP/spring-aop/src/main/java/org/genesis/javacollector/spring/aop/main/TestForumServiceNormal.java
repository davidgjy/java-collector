package org.genesis.javacollector.spring.aop.main;

import org.genesis.javacollector.spring.aop.proxy.ForumService;
import org.genesis.javacollector.spring.aop.proxy.ForumServiceImpl;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: TestForumServiceNormal
 * @Package proxy
 * @Description: test forum service by aop
 * @date 2018/8/19 21:16
 */
public class TestForumServiceNormal {
    public static void main(String[] args) {
        // 业务类正常编码的测试
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
