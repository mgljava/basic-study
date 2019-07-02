package com.github.mgljava.basicstudy.refactor;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String title;

  Price price;

  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public double getCharge(int dayRental) {
    return price.getCharge(dayRental);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPriceCode() {
    return price.getPriceCode();
  }

  public void setPriceCode(int priceCode) {
    switch (priceCode) {
      case REGULAR:
        price = new RegularPrice();
        break;
      case CHILDRENS:
        price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price Code.");
    }
  }

  public int getFrequentRenterPoints(int dayRental) {
    return price.getFrequentRenterPoints(dayRental);
  }
}
