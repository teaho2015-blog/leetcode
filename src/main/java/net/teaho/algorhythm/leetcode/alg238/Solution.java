package net.teaho.algorhythm.leetcode.alg238;

/**
 *
 * <p>238. 除自身以外数组的乘积
 * <p>https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * <p>思路：
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(2*n)
 *
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 47.94% 的用户
 * 内存消耗： 51.5 MB , 在所有 Java 提交中击败了 13.66% 的用户
 *
 * @author hetingleong@xiaomi.com
 * @date 2021-10
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        if (len == 1) {
            return nums;
        }

        int[] res = new int[len];
        int[] lf = new int[len];
        int[] rt = new int[len];

        lf[0] = 1;
        for (int i = 1; i < len; i++) {
            lf[i] = nums[i - 1] * lf[i - 1];
        }

        rt[len - 1] = 1;
        for (int i = len - 1; i > 0; i--) {
            rt[i - 1] = nums[i] * rt[i];
        }

        for (int i = 0; i < len; i++) {
            res[i] = lf[i] * rt[i];
        }

        return res;
    }

}
