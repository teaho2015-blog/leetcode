package net.teaho.algorhythm.leetcode.alg064minimumPathSum;

/**
 * <p>64. 最小路径和
 * <p>https://leetcode-cn.com/problems/minimum-path-sum/
 *
 *
 * <p>思路：看完题，明显是动态规划的题目。
 * 设 dp 为大小 m*n 矩阵，其中 dp[i][j] 的值代表直到走到 (i,j) 的最小路径和
 * <p>时间复杂度：O(m*n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
            new int[]{1, 3, 1},
            new int[]{1, 5, 1},
            new int[]{4, 2, 1}
        }));

        System.out.println(new Solution().minPathSum(new int[][]{
            new int[]{1, 3, 1},
            new int[]{1, 2, 3}
        }));


    }


}
