package advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.genesis.javacollector.spring.aop.introduce.ForumService;
import org.genesis.javacollector.spring.aop.introduce.Monitorable;
import static org.testng.Assert.*;
import org.testng.annotations.*;
public class IntroduceAdvisorTest {

    @Test
	public void introduce() {
		String configPath = "org/genesis/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");
        forumService.removeForum(10);
        Monitorable moniterable = (Monitorable)forumService;
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
	}
}
