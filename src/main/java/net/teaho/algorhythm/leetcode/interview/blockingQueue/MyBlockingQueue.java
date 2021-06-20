package net.teaho.algorhythm.leetcode.interview.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>百度、快手面试题
 * <p>自实现一个阻塞有界队列。
 *
 *
 */
public class MyBlockingQueue {

    private final int[] vals;

    private int capicity = 100;

    private int curSize = 0;

    /**
     * 队列尾巴位置，
     * ps.我采用类似Ringbuffer的做法
     */
    private int slot = 0;

    /**
     * 主锁
     */
    private Lock lock = new ReentrantLock();
    /**
     * 队列为空
     */
    private Condition isNull = lock.newCondition();
    /**
     * 队列已满
     */
    private Condition isFull = lock.newCondition();

    public MyBlockingQueue() {
        vals = new int[capicity];
    }

    public MyBlockingQueue(int capicity) {
        this.capicity = capicity;
        vals = new int[this.capicity];
    }


    public void push(int val) throws InterruptedException {

        try {
            lock.lock();

            while (curSize == capicity) {
                isFull.await();
            }
            if (slot != Integer.MAX_VALUE) {
                slot++;
            } else {
                slot = (slot % capicity) + capicity;
            }
            curSize++;
            vals[slot % capicity] = val;
            isNull.signal();

        } finally {
            lock.unlock();
        }


    }

    public int pop() throws InterruptedException {
        try {
            lock.lock();
            while (curSize == 0) {
                isNull.await();
            }
            curSize--;
            int result = vals[(slot - curSize) % capicity];
            isFull.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }


}
