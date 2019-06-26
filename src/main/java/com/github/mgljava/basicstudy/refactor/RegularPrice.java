package com.github.mgljava.basicstudy.refactor;


import static com.github.mgljava.basicstudy.refactor.Movie.REGULAR;

public class RegularPrice extends Price {

  @Override
  int getPriceCode() {
    return REGULAR;
  }

  public double getCharge(int dayRental) {
    double result = 2;
    if (dayRental > 2) {
      result += (dayRental - 2) * 1.5;
    }
    return result;
  }
}
