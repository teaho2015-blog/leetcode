package net.teaho.algorhythm.leetcode.alg239;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * <p>239. 滑动窗口最大值
 * <p>https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 *
 * <p>思路：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(k)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2021-12
 * @since 1.0.0
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];

        }
        return res;


    }


}
