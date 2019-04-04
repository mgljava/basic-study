package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case1;

import lombok.Data;

@Data
public abstract class Handler {

  /**
   * 持有后继的责任对象
   */
  protected Handler successor;

  /**
   * 示意处理请求的方法，虽然这个示意方法是没有传入参数的 但实际是可以传入参数的，根据具体需要来选择是否传递参数
   */
  public abstract void handleRequest();
}
