package com.github.mgljava.basicstudy.refactor;


import static com.github.mgljava.basicstudy.refactor.Movie.NEW_RELEASE;

public class NewReleasePrice extends Price {

  public double getCharge(int dayRental) {
    return dayRental * 3;
  }

  @Override
  int getPriceCode() {
    return NEW_RELEASE;
  }

  @Override
  public int getFrequentRenterPoints(int dayRental) {
    return dayRental > 1 ? 2 : 1;
  }
}
