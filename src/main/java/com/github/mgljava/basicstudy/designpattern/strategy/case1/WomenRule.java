package com.github.mgljava.basicstudy.designpattern.strategy.case1;


public class WomenRule implements AbstractRule {

    @Override
    public void sayNumber(String number) {
        System.out.println("Women should Say number is " + number);
    }
}
