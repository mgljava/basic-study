package com.github.mgljava.basicstudy.leetcode.middle;

public class PowxN50 {

  // 暴力(时间复杂度 O(n))
  public double myPow1(double x, int n) {
    if (n == 1) {
      return 0;
    }
    double result = 1;
    for (int i = 0; i < n; i++) {
      result *= x;
    }
    return result;
  }

  /**
   * 分治法<br>
   * <p>x^n --> 2^10 : 2^5 * 2^5 -> 2^2 * 2^2 * 2（注意奇偶性）</p>
   * <p>pow(x,n)</p>
   * <p> sub problem: subresult = pow(x, n/2)</p>
   * <p> log(N)</p>
   * <p>
   *   merge: <br>
   *    if n % 2 == 1 { <br>
   *      // odd. <br>
   *      result = subresult * subresult * x <br>
   *    } else { <br>
   *      // even <br>
   *      result = subresult * subresult <br>
   *    } <br>
   * </p>
   */

  public static void main(String[] args) {
    double v = new PowxN50().myPow2(2, -2);
    System.out.println(v);
  }

  // 分治法的代码逻辑
  public double myPow(double x, int n) {
    if (n ==0) {
      return 1;
    }
    if (n <0) {
      return 1/myPow(x,-n);
    }
    if (n%2 == 0) {
      return myPow(x*x,n/2);
    }else {
      return x*myPow(x*x, n/2);
    }
  }

  public double myPow2(double x, int n) {
    long N = n;
    return N >=0?fastPow(x,N):1.0/fastPow(x,-N);
  }

  double fastPow(double x, long n) {
    if (n == 0) {
      return 1;
    }
    double half = fastPow(x, n / 2);
    return n % 2==0?half*half:half*half*x;
  }
}
