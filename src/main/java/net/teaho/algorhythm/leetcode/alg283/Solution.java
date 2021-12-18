package net.teaho.algorhythm.leetcode.alg283;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-12
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cursor = -1;
        for (int i = 0; i < nums.length; i++) {
            if (cursor == -1 && nums[i] == 0) {
                cursor = i;
            }

            if (cursor != -1 && nums[i] != 0) {
                nums[cursor] = nums[i];
                nums[i] = 0;
                cursor++;
            }

        }

    }

}
