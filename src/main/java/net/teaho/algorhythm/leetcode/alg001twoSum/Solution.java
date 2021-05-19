package net.teaho.algorhythm.leetcode.alg001twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 一遍hash o(n)
 * @author teaho2015
 */
public class Solution {

    /**
     *
     * @param nums
     * @param target
     * @return null is not found.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(1<<5);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1, 4, 6, 20, 2}, 10)));
    }

}
