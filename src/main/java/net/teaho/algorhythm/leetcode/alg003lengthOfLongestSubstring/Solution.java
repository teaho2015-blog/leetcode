package net.teaho.algorhythm.leetcode.alg003lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>3. 无重复字符的最长子串
 * <p>https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>
 *
 * <p>Hash+双指针滑动窗口，
 * 思路：不断找两重复字符间的最大距离。
 *
 * <p>时间复杂度：o(n)
 *
 */
public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(1 << 10);
        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1;
            }

            if (right - left + 1  > maxLen) {
                maxLen = right - left + 1;
            }

            right++;


        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abaccscbwyzxcx"));
        System.out.println(new Solution().lengthOfLongestSubstring("awbfghijkbu"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));

    }

}
