package net.teaho.algorhythm.leetcode.alg301;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.*;

/**
 *
 * 301. 删除无效的括号<p/>
 * https://leetcode.cn/problems/remove-invalid-parentheses/?envType=problem-list-v2&envId=2cktkvj
 *
 * 广度优先搜索，找到了就返回
 *
 *
 * @author teaho2015@gmail.com
 * @date 2025-02
 */
public class Solution1 {


    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> currSet = new HashSet<>();

        currSet.add(s);
        while (true) {
            for (String string : currSet) {
                if (isValid(string)) {
                    result.add(string);
                }
            }

            if (result.size() > 0) {
                return result;
            }
            Set<String> loopSet = new HashSet<>();
            for (String string : currSet) {
                for (int i = 0; i < string.length(); i++) {
                    if (i > 0 && string.charAt(i) == string.charAt(i - 1)) {
                        continue;
                    }
                    if (string.charAt(i) == '(' || string.charAt(i) == ')') {
                        loopSet.add(string.substring(0, i) + string.substring(i + 1));
                    }
                }
            }
            currSet = loopSet;
        }
    }


    private boolean isValid(String s) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if(s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
