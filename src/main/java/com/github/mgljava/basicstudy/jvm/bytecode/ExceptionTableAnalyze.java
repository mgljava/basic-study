package com.github.mgljava.basicstudy.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 字节码的异常信息表分析
 * Java字节码对于异常的处理方式
 *
 * 1. 统一采用异常表的方式来对异常进行处理
 * 2. 在之前的JDK1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式(jsr, ret)
 * 3. 当异常处理存在 finally语句块时，现代化的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面
 */
public class ExceptionTableAnalyze {

  private void test() throws Exception {
    try {
      InputStream is = new FileInputStream("test.txt");

      ServerSocket serverSocket = new ServerSocket(9999);
      serverSocket.accept();
    } catch (FileNotFoundException ex) {

    } catch (IOException ex) {

    } catch (Exception ex) {

    } finally {
      System.out.println("finally");
    }
  }
}
