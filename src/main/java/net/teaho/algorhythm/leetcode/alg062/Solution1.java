package net.teaho.algorhythm.leetcode.alg062;

/**
 * <p>62. 不同路径
 * <p>https://leetcode-cn.com/problems/unique-paths/
 *
 * <p>思路：第一看题目，就可以想到一定是有内在规律或公式的，当时没想出具体公式，参考了官方答案是排列组合
 * <p>时间复杂度：O(m)
 * <p>空间复杂度：O(1)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution1 {


    public int uniquePaths(int m, int n) {
        long res = 1;
        // 排列组合，把短的m -1抽出来
        for (int i = 0; i < Math.min(m - 1, n -1 ); i++) {
            res *= m + n -2 -i;
            res /= i + 1;
        }

        return (int)res;
    }


    public static void main(String[] args) {

        System.out.println(new Solution1().uniquePaths(7, 3));

    }

}
