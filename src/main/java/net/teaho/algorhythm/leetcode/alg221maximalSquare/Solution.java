package net.teaho.algorhythm.leetcode.alg221maximalSquare;

/**
 * <p>221. 最大正方形
 * <p>https://leetcode-cn.com/problems/maximal-square/
 * <p>
 * 思路：动态规划。可脑补三个重叠正方形。 dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
 * 时间复杂度：
 * 空间复杂度：
 *
 * @author teaho2015@gmail.com
 * @date 2021-10
 * @since 1.0.0
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, colums = matrix[0].length;
        int[][] dp = new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSize = Math.max(dp[i][j], maxSize);

                }
            }
        }
        return maxSize * maxSize;
    }


}
