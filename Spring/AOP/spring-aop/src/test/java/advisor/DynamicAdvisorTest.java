package advisor;

import org.genesis.javacollector.spring.aop.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.*;
public class DynamicAdvisorTest {

	@Test
	public void dynamic() {
		String configPath = "org.genesis.javacollector.spring.aop/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter2");
		waiter.serveTo("Peter");
		waiter.greetTo("Peter");		
		waiter.serveTo("Peter");
		waiter.greetTo("John");
	}
}
