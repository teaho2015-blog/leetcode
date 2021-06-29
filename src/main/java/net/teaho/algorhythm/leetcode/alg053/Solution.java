package net.teaho.algorhythm.leetcode.alg053;

/**
 * <p>53. 最大子序和
 * <p>https://leetcode-cn.com/problems/maximum-subarray/
 *
 * <p> 思路：其实就是想办法找出和为正数的最大值（max）, 这种思路是动态规划，Leetcode的官方答案给出了数学上的证明，可以看一下
 * <p> 时间复杂度：O(n)
 * <p> 空间复杂度：O(1)
 *
 * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 95.58% 的用户
 * 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 85.48% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
