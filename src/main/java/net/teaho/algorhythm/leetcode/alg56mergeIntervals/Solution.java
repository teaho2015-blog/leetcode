package net.teaho.algorhythm.leetcode.alg56mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>56. 合并区间
 * <p>https://leetcode-cn.com/problems/merge-intervals/
 *
 * <p>思路：想清楚如何合并两个区间就好
 * <p>时间复杂度：O(NlgN) + O(N) N为区间数量
 * <p>空间复杂度： O(N)
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else if (interval[1] > res[idx][1]) {
                res[idx][1] = interval[1];
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }



    public static void main(String[] args) {
        {
            int[][] res = new Solution().merge(new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8, 10},
                new int[]{15,18}
            });
            System.out.println('[');
            Arrays.stream(res)
                .forEach(ints -> System.out.println(Arrays.toString(ints)));
            System.out.println(']');

        }

    }
}
