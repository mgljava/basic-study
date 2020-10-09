package com.github.mgljava.basicstudy.leetcode.easy;

// 停车系统
public class ParkingSystem {

  int[] container;

  public ParkingSystem(int big, int medium, int small) {
    container = new int[] {big, medium, small};
  }

  public boolean addCar(int carType) {
    return container[carType - 1]-- > 0;
  }
}
