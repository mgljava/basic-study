package com.github.mgljava.basicstudy.designpattern.newversion.compose;

public class MainTest {

  public static void main(String[] args) {
    ConcreteCompany root = new ConcreteCompany("北京总公司");
    root.add(new HRDept("总公司人力资源部门"));
    root.add(new FinanceDept("总公司财务部门"));

    ConcreteCompany company1 = new ConcreteCompany("上海华东分公司");
    company1.add(new HRDept("华东人力资源部门"));
    company1.add(new FinanceDept("华东财务部门"));
    root.add(company1);

    System.out.println("结构图");
    root.disPlay(1);

    System.out.println("职责");
    root.lineOfDuty();
  }
}
