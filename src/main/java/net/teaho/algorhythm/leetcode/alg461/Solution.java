package net.teaho.algorhythm.leetcode.alg461;

/**
 *
 * 461. 汉明距离<p>
 * https://leetcode.cn/problems/hamming-distance/description/?envType=problem-list-v2&envId=2cktkvj&<br/>
 *
 *
 * 内置位计数功能 先执行异或，然后
 *
 * 时间复杂度：O(1) <br/>
 * 空间复杂度： O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
