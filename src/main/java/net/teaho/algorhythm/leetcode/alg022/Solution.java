package net.teaho.algorhythm.leetcode.alg022;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>22. 括号生成
 * <p>https://leetcode-cn.com/problems/generate-parentheses/
 *
 * <p>思路：二叉树深度优先实现（很有意思的实现）
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 *
 * <p>时间复杂度：O(4^n/ √n​)
 * <p>空间复杂度：O(4^n/ √n​)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {


    // 做加法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     *
     * @param s
     * @param left 左括号数
     * @param right 有括号数
     * @param n
     * @param res
     */
    private void dfs(String s, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(s + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(s + ")", left, right + 1, n, res);
        }

    }


    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

}
