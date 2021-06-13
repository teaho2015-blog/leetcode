package net.teaho.algorhythm.leetcode.alg011maxArea;

/**
 * <p>11. 盛最多水的容器
 * <p>https://leetcode-cn.com/problems/container-with-most-water/
 *
 * <p>双指针计算
 * <p>时间复杂度：O(n)
 * <p>空间复杂度: O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public int maxArea(int[] height) {
        int i = 0, j = height.length -1, max = 0;
        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i)* height[i++])  : Math.max(max, height[j] * (j-- - i));
        }
        return max;
    }


    public static void main(String[] args) {
        {
            int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
            System.out.println(new Solution().maxArea(arr));
        }

        {
            int[] arr = new int[]{1,1};
            System.out.println(new Solution().maxArea(arr));
        }
    }
}
