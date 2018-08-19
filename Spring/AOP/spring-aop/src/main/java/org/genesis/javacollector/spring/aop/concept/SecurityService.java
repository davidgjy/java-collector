package org.genesis.javacollector.spring.aop.concept;

public interface SecurityService {
    boolean checkAccess(User user, String service);
}
