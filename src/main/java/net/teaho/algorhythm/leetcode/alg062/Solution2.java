package net.teaho.algorhythm.leetcode.alg062;

/**
 * <p>62. 不同路径
 * <p>https://leetcode-cn.com/problems/unique-paths/
 *
 * <p>思路：动态规划。 https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
 * 可将题目看作为前面走过的子集相加等于结果集
 *
 * <p>由于我们每一步只能从向下或者向右移动一步，因此要想走到 f(i,j)，
 * 如果向下走一步，那么会从 f(i−1,j) 走过来；如果向右走一步，
 * 那么会从 f(i,j−1) 走过来。因此我们可以写出动态规划转移方程：
 *
 *
 * <p>f(i,j)=f(i−1,j)+f(i,j−1)
 *
 * <p>时间复杂度：O(mn)
 * <p>空间复杂度：O(mn)
 *
 *
 */
public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];

    }


    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(3, 7));
        System.out.println(new Solution2().uniquePaths(3, 2));
    }
}
