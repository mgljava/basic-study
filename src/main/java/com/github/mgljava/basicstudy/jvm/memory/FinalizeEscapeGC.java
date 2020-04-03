package com.github.mgljava.basicstudy.jvm.memory;

public class FinalizeEscapeGC {

  public static FinalizeEscapeGC SAVE_HOOK = null;

  public void isAlive() {
    System.out.println("i am alive.");
  }

  /**
   * 任何一个对象的 finalize方法只会被执行一次
   * @throws Throwable
   */
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalize method invoked!");
    FinalizeEscapeGC.SAVE_HOOK = this;
  }

  public static void main(String[] args) throws Exception {
    SAVE_HOOK = new FinalizeEscapeGC();

    SAVE_HOOK = null;
    System.gc();

    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no i am dead");
    }

    SAVE_HOOK = null;
    System.gc();
    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no i am dead");
    }
  }
}
