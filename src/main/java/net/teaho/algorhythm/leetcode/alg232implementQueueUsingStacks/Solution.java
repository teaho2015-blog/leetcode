package net.teaho.algorhythm.leetcode.alg232implementQueueUsingStacks;

/**
 * @author teaho2015@gmail.com
 * @date 2021-06
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

    }
}
