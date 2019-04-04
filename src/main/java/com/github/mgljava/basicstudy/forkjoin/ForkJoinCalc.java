package com.github.mgljava.basicstudy.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalc extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long THRESHOLD = 1000L; //临界值

    public ForkJoinCalc(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (end + start) / 2;
            ForkJoinCalc left = new ForkJoinCalc(start, middle);
            left.fork(); // 拆分，并将该子任务压入线程队列

            ForkJoinCalc right = new ForkJoinCalc(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
