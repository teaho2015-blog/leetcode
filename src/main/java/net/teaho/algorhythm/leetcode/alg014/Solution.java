package net.teaho.algorhythm.leetcode.alg014;

import java.util.Arrays;

/**
 * 14. 最长公共前缀 <p/>
 * https://leetcode.cn/problems/longest-common-prefix/description/ <p/>
 *
 * <p/>
 *
 * 时间复杂度: O(nm) <p/>
 * 空间复杂度：O(1) <p/>
 *
 * @author teaho2015@gmail.com
 * @date 2025-04
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int size = strs.length;
        Arrays.sort(strs);
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < strs[0].length() && i < strs[size - 1].length(); i++) {
            char c = strs[0].charAt(i);
            if (strs[0].charAt(i) == strs[size - 1].charAt(i)) {
                res.append(c);
            } else {
                break;
            }
        }
        return res.toString();

    }
}
