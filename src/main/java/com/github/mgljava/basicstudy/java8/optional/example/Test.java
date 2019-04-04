package com.github.mgljava.basicstudy.java8.optional.example;

import java.util.Optional;

public class Test {

  public static void main(String[] args) {

    Test test = new Test();
    // System.out.println(test.getCarInsuranceName(new Person()));

    // System.out.println(test.getCarInsuranceName2(new Person()));

    Insurance insurance = new Insurance();
    Car car = new Car();
    car.setInsurance(Optional.of(insurance));
    Person person = new Person();
    person.setCar(Optional.of(car));
    System.out.println(test.getCarInsuranceName3(person));

  }

  private String getCarInsuranceName(Person person) {
    return person.getCar().get().getInsurance().get().getName();
  }

  private String getCarInsuranceName2(Person person) {
    return Optional.ofNullable(person).map(person1 -> person1.getCar().get())
        .map(car -> car.getInsurance().orElse(new Insurance()))
        .map(Insurance::getName).orElse("name");
  }

  public String getCarInsuranceName3(Person person) {
    return Optional.ofNullable(person)
        .flatMap(Person::getCar)
        .flatMap(Car::getInsurance)
        .map(Insurance::getName)
        .orElse("Unknown");
  }
}
