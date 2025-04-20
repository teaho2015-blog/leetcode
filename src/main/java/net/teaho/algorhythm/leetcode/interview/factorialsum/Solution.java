package net.teaho.algorhythm.leetcode.interview.factorialsum;

import java.util.stream.IntStream;

/**
 * 招商银行题
 *
 * <p/>给定数组，算正数的阶乘之和。
 * <p/>题目指定使用stream和递归。
 *
 * @author teaho2015@gmail.com
 * @date 2025-04
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int calculateFactorialSum(int[] numbers) {
        return  IntStream.of(numbers)
            .map(Solution::factorial)
            .sum();
    }


    private static int factorial(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(new Solution().calculateFactorialSum(new int[] {2, 3, -1, 0, 5}));
    }
}
