package net.teaho.algorhythm.leetcode.alg049;

import java.util.*;

/**
 * <p>49. 字母异位词分组
 * <p>https://leetcode-cn.com/problems/group-anagrams/
 *
 * <p>思路：先排序，后利用哈希表归类
 * <p>时间复杂度：O(nk logk) 其中n是strs中的字符串的数量，k是strs中的字符串的的最大长度。
 * <p>空间复杂度：O(nk)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(1 << 8);

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.computeIfAbsent(s, s1 -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        System.out.println(new Solution().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));



    }
}
