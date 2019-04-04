package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case2;

public class ProjectManager extends Handler {

  @Override
  public String handleFeeRequest(double fee) {
    String result = "";

    if (fee < 500) {
      result = "成功：项目经理同意聚餐费用，金额为" + fee + "元";
    } else {
      if (getSuccessor() != null) {
        return getSuccessor().handleFeeRequest(fee);
      }
    }
    return result;
  }
}
