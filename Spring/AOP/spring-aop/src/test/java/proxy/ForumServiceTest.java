package proxy;
import java.lang.reflect.Proxy;
import static org.testng.Assert.*;

import org.genesis.javacollector.spring.aop.introduce.ForumService;
import org.genesis.javacollector.spring.aop.proxy.CglibProxy;
import org.genesis.javacollector.spring.aop.proxy.ForumServiceImpl;
import org.testng.annotations.*;

public class ForumServiceTest {
	@Test
	public void proxy() {
		//使用CGLib动态代理
		CglibProxy cglibProxy = new CglibProxy();
		ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(10);
		forumService.removeTopic(1023);
		
	}
}

