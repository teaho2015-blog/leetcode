package net.teaho.algorhythm.leetcode.alg438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 438. 找到字符串中所有字母异位词<p>
 * <p/>https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/2969498/liang-chong-fang-fa-ding-chang-hua-chuan-14pd/?envType=problem-list-v2&envId=2cktkvj
 *
 *
 * <p/>滑动窗格：定长窗口
 *
 * <p/>时间复杂度：O(Em+n) 击败60%
 * <p/>空间复杂度：O(E)
 *
 * E为字符集(a-z)的大小
 *
 * @author teaho2015@gmail.com
 * @date 2025-04
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cntP[p.charAt(i) - 'a']++;
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++;
            int left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(cntS, cntP)) {
                res.add(left);
            }
            cntS[s.charAt(left) - 'a']--;
        }
        return res;
    }
}
