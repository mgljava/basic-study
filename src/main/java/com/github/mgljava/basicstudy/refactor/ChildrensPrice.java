package com.github.mgljava.basicstudy.refactor;


import static com.github.mgljava.basicstudy.refactor.Movie.CHILDRENS;

public class ChildrensPrice extends Price {

  @Override
  int getPriceCode() {
    return CHILDRENS;
  }

  public double getCharge(int dayRental) {
    double result = 1.5;
    if (dayRental > 3) {
      result += (dayRental - 3) * 1.5;
    }
    return result;
  }
}
