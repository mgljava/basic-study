package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;
    Semaphore semaphore = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            int i1 = semaphore.availablePermits();
            if (i1 == 1) {
                printFoo.run();
                semaphore.acquire();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            int i1 = semaphore.availablePermits();
            if (i1 == 0) {
                printBar.run();
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(2);
        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        });
        fooBar.foo(foo);

        fooBar.bar(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        }));
    }
}
