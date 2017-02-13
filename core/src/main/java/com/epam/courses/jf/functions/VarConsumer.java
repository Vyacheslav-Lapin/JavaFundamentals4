package com.epam.courses.jf.functions;

@FunctionalInterface
public interface VarConsumer<T> {

    void accept(T... t);
}
