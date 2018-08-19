package org.genesis.javacollector.spring.aop.advisor;

import org.springframework.aop.support.IntroductionInfoSupport;

import org.genesis.javacollector.spring.aop.introduce.Monitorable;

public class MyIntroduceInfo extends IntroductionInfoSupport{
   public MyIntroduceInfo(){
	   super();
	   super.publishedInterfaces.add(Monitorable.class);
   }
}
