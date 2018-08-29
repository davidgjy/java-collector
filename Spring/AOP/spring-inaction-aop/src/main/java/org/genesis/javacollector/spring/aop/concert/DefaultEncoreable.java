package org.genesis.javacollector.spring.aop.concert;

public class DefaultEncoreable implements Encoreable {
  @Override
  public void performEncore() {
    System.out.println("Perform encore");
  }
}
