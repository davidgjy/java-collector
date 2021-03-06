package advisor;

import org.genesis.javacollector.spring.aop.advice.Waiter;
import org.genesis.javacollector.spring.aop.advisor.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class StaticMethodAdvisorTest {

	@Test
	public void staticMethod(){
		String configPath = "org/genesis/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		Seller seller = (Seller)ctx.getBean("seller");
		waiter.greetTo("John");
		waiter.serveTo("John");
		seller.greetTo("John");	
	}
}
