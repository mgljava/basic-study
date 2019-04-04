package com.github.mgljava.basicstudy.designpattern.strategy.case2;

public class ValidationStrategyTest {

  private final ValidationStrategy validationStrategy;

  private ValidationStrategyTest(ValidationStrategy validationStrategy) {
    this.validationStrategy = validationStrategy;
  }

  public boolean validate(String s) {
    return validationStrategy.execute(s);
  }

  public static void main(String[] args) {
    ValidationStrategyTest strategyTest = new ValidationStrategyTest(new IsAllLowerCase());
    System.out.println(strategyTest.validate("name"));
    strategyTest = new ValidationStrategyTest(new IsNumeric());
    System.out.println(strategyTest.validate("Hello"));
    System.out.println(strategyTest.validate("123"));
  }
}
