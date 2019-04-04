package com.github.mgljava.basicstudy.designpattern.interface_;

public interface RocketSim {
    String s = "";
    abstract double getMass();

    public double getThrust();

    void setSimTime(double t);
}
