package com.github.mgljava.basicstudy.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
    for (Rental rental : rentals) {
      result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge(rental)).append("\n");
    }
    result.append("Amount owed is ").append(getTotalCharge()).append("\n");
    result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
    return result.toString();
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    for (Rental rental : rentals) {
      result += rental.getFrequentRenterPoints(rental);
    }
    return result;
  }

  public double getTotalCharge() {
    double result = 0;
    for (Rental rental : rentals) {
      result += rental.getCharge(rental);
    }
    return result;
  }

  public static void main(String[] args) {
    Movie movie = new Movie("A1", 0);
    Movie movie2 = new Movie("B1", 2);
    Movie movie3 = new Movie("C3", 1);

    Rental rental = new Rental(movie, 3);
    Rental rental2 = new Rental(movie2, 1);
    Rental rental3 = new Rental(movie3, 6);
    Customer customer = new Customer("Zhang");
    customer.addRental(rental);
    customer.addRental(rental2);
    customer.addRental(rental3);

    System.out.println(customer.statement());
  }
}












