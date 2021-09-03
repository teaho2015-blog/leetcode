package net.teaho.algorhythm.leetcode.alg169majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 169. 多数元素
 *
 * 思路：哈希表
 * 时间复杂度： O(n)
 * 空间复杂度： O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-09
 */
public class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = map.get(num);
                if (val + 1 > max) {
                    max = val + 1;
                    res = num;
                }
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return res;

    }
}
