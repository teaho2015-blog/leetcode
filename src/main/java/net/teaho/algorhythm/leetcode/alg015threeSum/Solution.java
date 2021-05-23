package net.teaho.algorhythm.leetcode.alg015threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
 * <p>
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(log N)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //quick sort
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return result;

            if (i >0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lf = i + 1, rt = len - 1;
            while (lf < rt) {
                int sum = nums[i] + nums[lf] + nums[rt];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[lf]);
                    l.add(nums[rt]);
                    result.add(l);
                    while (lf< rt && nums[lf] == nums[lf+1]) lf++;
                    while (lf< rt && nums[lf] == nums[lf+1]) rt--;
                    lf++;
                    rt--;
                } else if (sum < 0) {
                    lf++;
                } else {
                    rt--;
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}
