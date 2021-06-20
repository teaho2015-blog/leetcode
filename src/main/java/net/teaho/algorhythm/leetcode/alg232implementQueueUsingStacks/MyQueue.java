package net.teaho.algorhythm.leetcode.alg232implementQueueUsingStacks;


import java.util.Stack;

/**
 * <p>232. 用栈实现队列
 * <p>https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 50.66% 的用户
 *
 * <p>时间复杂度：O(1) pop() peek()均摊 O(1)
 * <p>空间复杂度：O(n)
 *
 */
class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();


    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}