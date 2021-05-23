package net.teaho.algorhythm.leetcode.alg215findKthLargest;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 时间复杂度O(N*LgN)
 */
public class Solution2 {

    private static final Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;

        while (true) {
            int index = partition(nums, left, right);
            if (index > target) {
                right = index - 1;
            } else if (index < target) {
                left = index + 1;
            } else {
                return nums[index];
            }
        }
    }

    /**
     * 在区间 [left, right] 这个区间执行 partition 操作
     */
    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int lt = left + 1;
        int rt = right;

        while (true) {

            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;

        }
        swap(nums, left, lt - 1);

        return lt - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int result = new Solution2().findKthLargest(new int[]{2, 6, 7, 10, 1, 7, 5}, 4);
        System.out.println(result);
    }
}
