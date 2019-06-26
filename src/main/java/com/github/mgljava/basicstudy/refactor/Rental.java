package com.github.mgljava.basicstudy.refactor;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rental {

  Movie movie;
  private int dayRented;

  public double getCharge(Rental rental) {
    return movie.getCharge(rental.dayRented);
  }


  public int getFrequentRenterPoints(Rental rental) {
    return movie.price.getFrequentRenterPoints(rental.dayRented, movie);
  }
}
