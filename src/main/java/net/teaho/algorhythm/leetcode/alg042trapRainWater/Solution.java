package net.teaho.algorhythm.leetcode.alg042trapRainWater;

/**
 *
 * 使用双指针
 *
 * 思想：一个重峦叠嶂的数据，其实左右指针可以忽略中间的“重重山”，就当是一大水沟，
 * 左右指针取小的值去算和移动就好；因为肯定是小的板决定装水容量
 *
 * 时间复杂度：O(n)。单次遍历的时间O(n)。
 * 空间复杂度：O(1) 的额外空间。left, right, left_max 和 right_max 只需要常数的空间。
 *
 */
public class Solution {

    public int trap(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += (rightMax - height[right]);
                }
                right--;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        {
            int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println(new Solution().trap(height));
        }
        {
            int[] height = new int[]{4, 2, 0, 3, 2, 5};
            System.out.println(new Solution().trap(height));
        }

    }
}
