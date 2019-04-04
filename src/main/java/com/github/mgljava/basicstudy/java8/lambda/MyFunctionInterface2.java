package com.github.mgljava.basicstudy.java8.lambda;

@FunctionalInterface
public interface MyFunctionInterface2<T, R> {

    R getValue(T t1, T t2);
}
