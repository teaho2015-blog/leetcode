package net.teaho.algorhythm.leetcode.alg085;

/**
 * <p>85. 最大矩形
 * <p>https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * <p>思路：暴力解法（ps.该题还有一种思路是单调栈）
 *  https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode-solution-bjlu/
 *  我们首先计算出矩阵的每个元素的左边连续 1 的数量，使用二维数组 left 记录，其中 left[i][j] 为矩阵第 i 行第 j 列元素的左边连续 1 的数量。
 *  随后，对于矩阵中任意一个点，我们枚举以该点为右下角的全 1 矩形。
 *
 * <p>时间复杂度：O(m^2 * n)
 * <p>空间复杂度：O(mn)
 *
 *
 */
public class Solution {


    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;

        int res = 0;
        int[][] vec = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] == '1')
                    vec[row][col] = (col == 0 ? 0 : vec[row][col - 1]) + 1;

                int width = vec[row][col];
                for (int k = row; k >= 0; --k) {
                    if (vec[k][col] == 0) break;    // 剪枝
                    width = Math.min(width, vec[k][col]);
                    res = Math.max(res, width * (row - k + 1));
                }
            }
        }
        return res;
    }

}
