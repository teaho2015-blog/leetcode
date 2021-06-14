package net.teaho.algorhythm.leetcode.alg010regMatch;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * <p>动态规划
 * <p>这个题刚看题就想到用动态规划（相信不少人也是用此法），不过其中有一些细节要考虑
 * <p>我写完后，最终还是采用Leetcode上的解法 https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-solution/
 *
 *  时间复杂度：O(mn)
 *  空间复杂度：O(mn)
 */
public class Solution {

        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }

    public static void main(String[] args) {
        {
            System.out.println(new Solution().isMatch("aa", "a"));
        }

        {
            System.out.println(new Solution().isMatch("aa", "a*"));
        }

        {
            System.out.println(new Solution().isMatch("ab", ".*"));
        }

        {
            System.out.println(new Solution().isMatch("aab", "c*a*b"));
        }



    }
}
