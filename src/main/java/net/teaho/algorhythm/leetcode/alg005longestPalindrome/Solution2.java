package net.teaho.algorhythm.leetcode.alg005longestPalindrome;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 扩展中心
 * <br/>
 * O(n²）<br/>
 * O(1)
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1) /2;
                end = i + (len) /2;
            }
        }
        return s.substring(start, end+ 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("babad"));
        System.out.println(new Solution2().longestPalindrome("cbbd"));
    }
}
