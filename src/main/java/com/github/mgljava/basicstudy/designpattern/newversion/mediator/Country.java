package com.github.mgljava.basicstudy.designpattern.newversion.mediator;

public abstract class Country {

  protected UnitedNations mediator;

  public Country(UnitedNations unitedNations) {
    this.mediator = unitedNations;
  }
}
