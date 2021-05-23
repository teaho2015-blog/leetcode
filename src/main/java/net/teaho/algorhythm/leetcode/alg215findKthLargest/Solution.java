package net.teaho.algorhythm.leetcode.alg215findKthLargest;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 大利用大根堆实现 o(n*log(k))
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();

    }

    public static void main(String[] args) {
        int result = new Solution().findKthLargest(new int[]{2, 6, 7, 10, 1, 7, 5}, 4);
        System.out.println(result);
    }

}
