package org.genesis.javacollector.spring.aop.advisor;

import org.genesis.javacollector.spring.aop.advice.Waiter;

public class WaiterDelegate {
	private Waiter waiter;
	public void service(String clientName) {
		waiter.greetTo(clientName);
		waiter.serveTo(clientName);
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
}
