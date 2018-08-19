package advisor;

import org.genesis.javacollector.spring.aop.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.*;
public class RegexpAdvisorTest {

	@Test
	public void regexp(){
		String configPath = "org.genesis.javacollector.spring.aop/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter1");
		waiter.greetTo("John");
		waiter.serveTo("John");
	}
}
