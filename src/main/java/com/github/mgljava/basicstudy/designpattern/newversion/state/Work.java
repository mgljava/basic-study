package com.github.mgljava.basicstudy.designpattern.newversion.state;

public class Work {

  private State currentState;
  private double hour;

  public Work() {
    this.currentState = new ForenoonState();
  }

  public State getCurrentState() {
    return currentState;
  }

  public void setCurrentState(State currentState) {
    this.currentState = currentState;
  }

  public double getHour() {
    return hour;
  }

  public void setHour(double hour) {
    this.hour = hour;
  }

  public void writeProgram() {
    currentState.writeProgram(this);
  }
}
