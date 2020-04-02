package com.github.mgljava.basicstudy.jvm.memory.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx20M
 * -Xms20M
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

  static class OOMObject {

  }

  public static void main(String[] args) {
    List<OOMObject> oomObjectList = new ArrayList<>();
    while (true) {
      oomObjectList.add(new OOMObject());
    }
  }
}
