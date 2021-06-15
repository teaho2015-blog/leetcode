package net.teaho.algorhythm.leetcode.alg136singleNumber;

/**
 * <p>136. 只出现一次的数字
 * <p>https://leetcode-cn.com/problems/single-number/
 *
 * <p>思路：异或
 *
 * <p>这同时能够解出一个数组中存在的奇数个的那个数字、这是乐信二面面试题。
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1,2,3,1,2,3,2}));
    }
}
