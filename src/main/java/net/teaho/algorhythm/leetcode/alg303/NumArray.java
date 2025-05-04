package net.teaho.algorhythm.leetcode.alg303;

/**
 * <p/>303. 区域和检索 - 数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable/description/
 *
 *
 * <p/>前缀和
 * <p/>时间复杂度：初始化O(n)，计算：O(1)
 * <p/>空间复杂度：O(n)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2025-05
 */
public class NumArray {
    private final int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = nums[i] + s[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
