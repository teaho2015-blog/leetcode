package net.teaho.algorhythm.leetcode.alg207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>207. 课程表
 * <p>https://leetcode-cn.com/problems/course-schedule/
 *
 * <p>思路： 图的BFS遍历 https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
 * <p>1. 有向图是否成环
 * <p>2. 维护一个入度表，然后从源头（入度为零的点）一一剔除课程
 *
 *
 * <p>时间复杂度：O(n×m) n为节点，m为连接线
 * <p>空间复杂度：O(n×m)
 *
 * @author hetingleong@xiaomi.com
 * @date 2021-09
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            reverse.add(0, new ArrayList<>());
        }
        //生成入度集和反转集
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            reverse.get(prerequisite[1]).add(prerequisite[0]);
        }
        //获取入度为0的课程，即图的开端
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();

            numCourses--;

            for (Integer integer : reverse.get(course)) {
                if (--indegree[integer] == 0) {
                    queue.add(integer);
                }
            }
        }



        return numCourses == 0;
    }



}
