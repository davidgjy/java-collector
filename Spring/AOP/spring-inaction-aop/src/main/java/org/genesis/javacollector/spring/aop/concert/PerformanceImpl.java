package org.genesis.javacollector.spring.aop.concert;

public class PerformanceImpl implements Performance {

  @Override
  public void perform() {
    System.out.println("PerformanceImpl.perform");
  }

}
