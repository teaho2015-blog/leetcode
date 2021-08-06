package net.teaho.algorhythm.leetcode.alg084;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>84. 柱状图中最大的矩形
 * <p>https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 *
 * <p>思路：单调栈  说白了，这题考的基础模型其实就是：在一维数组中对每一个数找到第一个比自己小的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
 * <p>时间复杂度：O(N)
 * <p>空间复杂度：O(N)
 *
 *
 */
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //记录左右边界
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;

                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);


        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }


        return res;
    }

}
