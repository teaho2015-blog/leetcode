package net.teaho.algorhythm.leetcode.alg031nextPermutation;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * <p>
 * 具体地，我们这样描述该算法，对于长度为 nn 的排列 aa：
 * <p>
 * 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
 * <p>
 * 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。
 * <p>
 * 交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
 * <p>
 * 时间： O(N)
 * 空间： O(1)
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        {
            int[] arr = new int[]{4, 5, 2, 6, 3, 1};
            new Solution().nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }

        {
            int[] arr = new int[]{1,5,1};
            new Solution().nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }
        {
            int[] arr = new int[]{1, 1};
            new Solution().nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }

    }
}
