package net.teaho.algorhythm.leetcode.alg042trapRainWater;

/**
 * 暴力解法
 * 将每个数组元素的水位高低单独算出来并累加
 *
 * 时间复杂度： O(n^2)。数组中的每个元素都需要向左向右扫描。
 *
 * 空间复杂度 O(1) 的额外空间。
 */
public class Solution2 {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println(new Solution2().trap(height));
        }
        {
            int[] height = new int[]{4, 2, 0, 3, 2, 5};
            System.out.println(new Solution2().trap(height));
        }
    }
}
