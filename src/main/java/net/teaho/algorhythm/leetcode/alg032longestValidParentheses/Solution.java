package net.teaho.algorhythm.leetcode.alg032longestValidParentheses;

/**
 * <p>32. 最长有效括号
 * <p>https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * <p>思路：方法三 在此方法中，我们利用两个计数器 left 和 right 记录做有括号数，并找出最大值。
 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {


    public int longestValidParentheses(String s) {

        int left = 0, right = 0, max = 0;
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
            if (left < right) {
                left = right = 0;
            } else if (left == right) {
                max = Math.max(max, left + right);
            }

        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                max = Math.max(max, left + right);
            }

        }


        return max;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses(""));


    }
}
