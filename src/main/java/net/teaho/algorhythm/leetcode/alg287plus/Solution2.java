package net.teaho.algorhythm.leetcode.alg287plus;

import net.teaho.algorhythm.leetcode.alg287.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>寻找重复数
 * <p>https://leetcode-cn.com/problems/find-the-duplicate-number/
 * <p>字节跳动飞书三面：在该题基础上修改条件，1.原题为只有一对重复数，现存在多对重复数，2.可以更改数组元素，3.返回所有重复数
 *
 * <p>思路：循环一遍，用数组元素值(nums[i]%n)作为数组下标，即nums[nums[i]%n].当检测到nums[nums[i]%n]>n则当前数字为重复数。
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution2 {

    public List<Integer> findDuplicate(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int pre = 0;
        for (int i = 0; i < len; i++) {


            int index = nums[i];
            if (index >= len) {
                index %= len;
            }
            if (nums[index] >= len) {
                res.add(index);
            }
            nums[index] += len;

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new Solution2().findDuplicate(new int[]{1, 3, 4, 5, 7, 2, 7, 3}));
    }
}
