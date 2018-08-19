package org.genesis.javacollector.spring.aop.concept;

public interface TransactionManager {
    void beginTransaction();
    void endTransaction();
}
