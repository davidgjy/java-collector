package org.genesis.javacollector.spring.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
  @DeclareParents(value = "org.genesis.javacollector.spring.aop.concert.Performance+", defaultImpl = DefaultEncoreable.class)
  public static Encoreable encoreable;
}
