package com.github.mgljava.basicstudy.designpattern.singleton.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class LazySingleton3Test2 {

  public static void main(String[] args) {
    try {
      LazySingleton3 instance1 = LazySingleton3.getInstance();
      ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
      out.writeObject(instance1);
      out.close();

      //deserialize from file to object
      ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
      LazySingleton3 instance2 = (LazySingleton3) in.readObject();
      in.close();

      System.out.println("instance1 hashCode=" + instance1.hashCode());
      System.out.println("instance2 hashCode=" + instance2.hashCode());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
