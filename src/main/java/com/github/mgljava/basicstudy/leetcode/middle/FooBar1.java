package com.github.mgljava.basicstudy.leetcode.middle;

public class FooBar1 {

    private static final Object monitor = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    if (flag) {
                        bar();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    monitor.notify();
                    flag = false;
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    if (!flag) {
                        foo();
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    monitor.notify();
                    flag = true;
                }
            }
        }).start();
    }

    private static void bar() {
        System.out.println("bar");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void foo() {
        System.out.println("foo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
