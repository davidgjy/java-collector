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
		// 使用JDK动态代理
/*		ForumService target = new ForumServiceImpl();
		PerformaceHandler handler = new PerformaceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(1012);*/

		//使用CGLib动态代理
		CglibProxy cglibProxy = new CglibProxy();
		ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(10);
		forumService.removeTopic(1023);
		
	}
	 
}
