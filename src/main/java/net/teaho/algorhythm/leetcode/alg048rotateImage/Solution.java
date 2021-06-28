package net.teaho.algorhythm.leetcode.alg048rotateImage;

import java.util.Arrays;

/**
 * <p>48. 旋转图像
 * <p>https://leetcode-cn.com/problems/rotate-image/
 *
 * <p>思路：方法三：翻转再翻转 https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
 * <p>时间复杂度：O(n) n为元素个数
 * <p>空间复杂度：O(1)
 *
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j] - matrix[n - i - 1][j];
                matrix[i][j] = matrix[i][j] - matrix[n - i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] += matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];
            }

        }
    }

    public static void main(String[] args) {
        {
            int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
            };
            new Solution().rotate(matrix);
            Arrays.stream(matrix)
                .forEach(ints -> System.out.println(Arrays.toString(ints)));
        }
    }
}
