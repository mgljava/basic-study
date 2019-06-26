package com.github.mgljava.basicstudy.refactor;

public abstract class Price {

  abstract int getPriceCode();

  abstract double getCharge(int dayRental);

  public int getFrequentRenterPoints(int dayRental, Movie movie) {
    if (movie.getPriceCode() == Movie.NEW_RELEASE && dayRental > 1) {
      return 2;
    }
    return 1;
  }
}
