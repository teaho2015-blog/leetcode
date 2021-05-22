package net.teaho.algorhythm.leetcode.alg003lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Hash+双指针滑动窗口 o(n)
 */
public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>(1 << 10);
        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1;
            }

            if (right - left + 1  > len) {
                len = right - left + 1;
            }

            right++;


        }
        return len;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().lengthOfLongestSubstring("abaccscbwyzxcx"));
//        System.out.println(new Solution().lengthOfLongestSubstring("awbfghijkbu"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));

    }

}
