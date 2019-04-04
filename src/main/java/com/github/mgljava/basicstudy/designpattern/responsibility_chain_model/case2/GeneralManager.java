package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case2;

public class GeneralManager extends Handler {

  @Override
  public String handleFeeRequest(double fee) {
    String result = "";
    if (fee >= 1000) {
      result = "成功：总经理同意聚餐费用，金额为" + fee + "元";
    } else {
      if (getSuccessor() != null) {
        return getSuccessor().handleFeeRequest(fee);
      }
    }
    return result;
  }
}
