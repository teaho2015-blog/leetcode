package net.teaho.algorhythm.leetcode.alg253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * <p>253. 会议室 II
 * https://leetcode.cn/problems/meeting-rooms-ii/solutions/2392308/hui-yi-shi-ii-by-leetcode-solution-fzxq/?envType=problem-list-v2&envId=2cktkvj
 *
 *
 * 优先队列
 * <p>时间复杂度：O(NlogN)
 * <p>空间复杂度：O(N)
 *
 * @author teaho2015@gmail.com
 * @date 2025-02
 */
public class Solution {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minTimeQ = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        minTimeQ.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (minTimeQ.peek() <= intervals[i][0]) {
                minTimeQ.poll();
            }
            minTimeQ.add(intervals[i][1]);
        }

        return minTimeQ.size();
    }

}
