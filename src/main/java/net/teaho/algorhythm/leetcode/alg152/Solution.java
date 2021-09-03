package net.teaho.algorhythm.leetcode.alg152;

/**
 *
 * <p>152. 乘积最大子数组
 * <p>https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 *
 * <p>思路：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imin = 1, imax = 1;

        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                 imax = imin;
                 imin = tmp;
            }

            imax = Math.max(num * imax, num);
            imin = Math.min(num * imin, num);
            max = Math.max(imax, max);
        }

        return max;
    }


}
