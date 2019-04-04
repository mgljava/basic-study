package com.github.mgljava.basicstudy.java8.optional;

import com.github.mgljava.basicstudy.java8.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

  /**
   * 一、Optional 容器类：用于尽量避免空指针异常
   * Optional.of(T t) : 创建一个 Optional 实例
   * Optional.empty() : 创建一个空的Optional 实例
   * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
   * isPresent() : 判断是否包含值
   * orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
   * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
   * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
   * flatMap(Function mapper):与 map类似，要求返回值必须是Optional
   */
  @Test
  public void test1() {
    Optional<Employee> op = Optional.of(new Employee());
    Employee employee = op.get();
    System.out.println(employee);
  }

  public static void main(String[] args) {
    // 构造一个Employee对象，设置对应参数
    Employee employee = new Employee();
    employee.setName("Zhangsan");
    Optional<Employee> optionalEmployee = Optional.of(employee);
    final String name = optionalEmployee.map(Employee::getName)
        .orElse("Unknown");
    System.out.println(name);
  }
}
