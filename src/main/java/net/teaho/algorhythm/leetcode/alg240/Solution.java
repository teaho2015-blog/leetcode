package net.teaho.algorhythm.leetcode.alg240;

/**
 *
 * <p>240. 搜索二维矩阵 II
 * <p>https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 *
 * <p>思路：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/
 * <p>除了暴力解决，比较优的解题思路是每行做二分查找，和Z型查找（先找所属列，然后在列中查找），这里用Z型查找思路
 *
 * <p>时间复杂度：O(m+n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-12
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix.length, collumLen = matrix[0].length;
        int i = 0, j = collumLen - 1;
        while (i < rowLen && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }



}
