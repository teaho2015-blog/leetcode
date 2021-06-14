package net.teaho.algorhythm.leetcode.alg020validParentheses;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>20. 有效的括号
 * <p>https://leetcode-cn.com/problems/valid-parentheses/
 *
 * <p>思路：看到题，直接想到用栈或队列解决
 *
 * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 99.26% 的用户
 * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 93.92% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid( "()[]{}"));
        System.out.println(new Solution().isValid( "([)]"));
        System.out.println(new Solution().isValid( "{[]}"));


    }
}
