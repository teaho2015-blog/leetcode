package net.teaho.algorhythm.leetcode.alg032longestValidParentheses;

import java.util.Stack;

/**
 * <p>32. 最长有效括号
 * <p>https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * <p>思路：方法二 栈
 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution2 {


    public int longestValidParentheses(String s) {

        int max=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek() + 1);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(new Solution2().longestValidParentheses("(()"));
        System.out.println(new Solution2().longestValidParentheses(")()())"));
        System.out.println(new Solution2().longestValidParentheses(""));


    }
}
