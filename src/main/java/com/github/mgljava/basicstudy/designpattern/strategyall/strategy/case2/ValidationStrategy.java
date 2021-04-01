package com.github.mgljava.basicstudy.designpattern.strategyall.strategy.case2;

/**
 * 验证输入的内容是否根据标准进行了恰当的格式化.
 */
public interface ValidationStrategy {

  boolean execute(String string);
}
