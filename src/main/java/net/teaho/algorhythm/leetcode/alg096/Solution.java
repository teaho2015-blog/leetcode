package net.teaho.algorhythm.leetcode.alg096;

/**
 *
 * <p>96. 不同的二叉搜索树
 * <p>https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * <p>思路：动态规划 https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
 * <p>时间复杂度：
 * <p>空间复杂度：
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1]*dp[i - j];
            }
        }


        return dp[n];
    }

}
