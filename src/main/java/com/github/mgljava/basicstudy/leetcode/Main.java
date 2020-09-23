package com.github.mgljava.basicstudy.leetcode;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedInputStream inputStream = new BufferedInputStream(System.in);
    DataInputStream dataInputStream = new DataInputStream(inputStream);
    String s2 = dataInputStream.readLine();
    int n = Integer.parseInt(s2);
    List<Score> scoreList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String s = dataInputStream.readLine();
      String[] s1 = s.split(" ");
      scoreList.add(new Score(s1[0], Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), Integer.parseInt(s1[3]),
          Integer.parseInt(s1[1]) + Integer.parseInt(s1[2]) + Integer.parseInt(s1[3])));
    }
    List<Score> collect = scoreList.stream().sorted((o1, o2) -> {
      if (o1.getTotal() < o2.getTotal()) {
        return 1;
      } else if (o1.getTotal().equals(o2.getTotal())) {
        if (o1.getYuwen() < o2.getYuwen()) {
          return 1;
        } else if (o1.getYuwen().equals(o2.getYuwen())) {
          if (o1.getShuxue() < o2.getShuxue()) {
            return 1;
          } else if (o1.getShuxue().equals(o2.getShuxue())) {
            return 0;
          } else {
            return -1;
          }
        } else {
          return -1;
        }
      } else {
        return -1;
      }
    }).collect(Collectors.toList());
    collect.forEach(item -> {
      System.out.print(item.getName() + " " + item.getYuwen() + " " + item.getShuxue() + " " + item.getWaiyu());
      System.out.println();
    });
  }
}

class Score {

  private String name;
  private Integer yuwen;
  private Integer shuxue;
  private Integer waiyu;
  private Integer total;

  public Score(String name, Integer yuwen, Integer shuxue, Integer waiyu, Integer total) {
    this.name = name;
    this.yuwen = yuwen;
    this.shuxue = shuxue;
    this.waiyu = waiyu;
    this.total = total;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getYuwen() {
    return yuwen;
  }

  public void setYuwen(Integer yuwen) {
    this.yuwen = yuwen;
  }

  public Integer getShuxue() {
    return shuxue;
  }

  public void setShuxue(Integer shuxue) {
    this.shuxue = shuxue;
  }

  public Integer getWaiyu() {
    return waiyu;
  }

  public void setWaiyu(Integer waiyu) {
    this.waiyu = waiyu;
  }
}
