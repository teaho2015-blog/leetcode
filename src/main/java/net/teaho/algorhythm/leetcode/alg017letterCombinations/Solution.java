package net.teaho.algorhythm.leetcode.alg017letterCombinations;

import java.util.*;

/**
 * <p>17. 电话号码的字母组合
 * <p>https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 *
 *  时间复杂度：O(3^m * 4^n)
 *  空间复杂度：O(m+n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, List<Character>> phoneMap = new HashMap<>();
        phoneMap.put('2', Arrays.asList('a', 'b', 'c'));
        phoneMap.put('3', Arrays.asList('d', 'e', 'f'));
        phoneMap.put('4', Arrays.asList('g', 'h', 'i'));
        phoneMap.put('5', Arrays.asList('j', 'k', 'l'));
        phoneMap.put('6', Arrays.asList('m', 'n', 'o'));
        phoneMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        phoneMap.put('8', Arrays.asList('t', 'u', 'v'));
        phoneMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;



    }

    private void backtrack(List<String> combinations, Map<Character, List<Character>> phoneMap, String digits, int index, StringBuffer combination) {

        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {

            char digit = digits.charAt(index);
            for (Character s : phoneMap.get(digit)) {
                combination.append(s);
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }



    }


    public static void main(String[] args) {
        {
            System.out.println(new Solution().letterCombinations("23"));
        }
        {
            System.out.println(new Solution().letterCombinations(""));
        }
        {
            System.out.println(new Solution().letterCombinations("2"));
        }

        {
            System.out.println(new Solution().letterCombinations("5629"));
        }
    }
}
