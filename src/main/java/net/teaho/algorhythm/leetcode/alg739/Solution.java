package net.teaho.algorhythm.leetcode.alg739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度 <p>
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=problem-list-v2&envId=2cktkvj&
 *
 *  <p>时间复杂度：O(n)
 *  <p>空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }

}
