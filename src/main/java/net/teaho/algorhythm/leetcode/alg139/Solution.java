package net.teaho.algorhythm.leetcode.alg139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>139. 单词拆分
 * <p>https://leetcode-cn.com/problems/word-break/
 *
 * <p>思路：动态规划
 * <p>时间复杂度：O(n^2)
 * <p>空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        for (boolean b : dp) {
            b = false;
        }
        dp[0] = true;
        for (int i = 0; i < len + 1; i++) {
            for (int j = i+1; j < len + 1; j++) {
                if (dp[i] && wordDictSet.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }


}
