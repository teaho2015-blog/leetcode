package net.teaho.algorhythm.leetcode.alg287;

/**
 * <p>287. 寻找重复数
 * <p>https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 *
 * <p>思路：算法-Floyd 判圈算法 https://zhuanlan.zhihu.com/p/373661568
 * https://zh.wikipedia.org/wiki/Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {


    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
