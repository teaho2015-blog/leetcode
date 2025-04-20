package net.teaho.algorhythm.leetcode.interview.calendarminrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 招行题
 *
 * <p/>给定6月的一串日期（[1,5],[5,10],[11,15]）预定出行，看需要多少次出行。（其实类似leetcode的会议室）
 *
 *
 *
 * @author teaho2015@gmail.com
 * @date 2025-04
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals Interval类ArrayList
     * @return int整型
     */
    public int calculateCalendarMinRows(ArrayList<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        if (intervals.size() == 1) {
            return 1;
        }
        PriorityQueue<Interval> minQ = new PriorityQueue<>(Comparator.comparing(interval -> interval.end));
        intervals.sort(Comparator.comparingInt(o -> o.start));
        minQ.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if (minQ.peek().end < tmp.start) {
                minQ.poll();
            }
            minQ.add(tmp);
        }
        return minQ.size();
    }

    public static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        //[[1,5], [5,10], [11,15]]
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(11, 15));

        System.out.println(new Solution().calculateCalendarMinRows(intervals));

    }
}



