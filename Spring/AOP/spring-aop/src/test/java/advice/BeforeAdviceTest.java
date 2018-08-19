package advice;

import org.genesis.javacollector.spring.aop.advice.GreetingBeforeAdvice;
import org.genesis.javacollector.spring.aop.advice.NaiveWaiter;
import org.genesis.javacollector.spring.aop.advice.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class BeforeAdviceTest {

    @Test
	public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice  advice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setInterfaces(target.getClass().getInterfaces());
        pf.setOptimize(true);
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy(); 
        proxy.greetTo("John");
        proxy.serveTo("Tom");
	}
}
