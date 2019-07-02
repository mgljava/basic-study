package com.github.mgljava.basicstudy.refactor;

public abstract class Price {

  abstract int getPriceCode();

  abstract double getCharge(int dayRental);

  public int getFrequentRenterPoints(int dayRental) {
    return 1;
  }
}
