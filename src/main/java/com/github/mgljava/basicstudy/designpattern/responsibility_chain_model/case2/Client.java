package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case2;

public class Client {

  public static void main(String[] args) {

    //先要组装责任链
    final Handler generalManager = new GeneralManager();
    final Handler deptManager = new DeptManager();
    final Handler projectManager = new ProjectManager();
    projectManager.setSuccessor(deptManager);
    deptManager.setSuccessor(generalManager);

    System.out.println(projectManager.handleFeeRequest(100));

  }
}
