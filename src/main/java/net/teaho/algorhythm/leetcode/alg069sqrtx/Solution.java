package net.teaho.algorhythm.leetcode.alg069sqrtx;

/**
 *
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * 时间复杂度：O(logx)，即为二分查找需要的次数。
 * 空间复杂度：O(1)。
 *
 */
public class Solution {

    public int mySqrt(int x) {

        int lf = 0, rt = x, res = -1;
        while(lf <= rt) {
            int mid = (rt - lf) / 2 + lf;
            long tmp = (long)mid * mid;
            if (tmp == x) {
                return mid;
            }
            if (tmp > x) {
                rt = mid - 1;
            } else {
                res = mid;
                lf = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

//        System.out.println(new Solution().mySqrt(8));
//        System.out.println(new Solution().mySqrt(0));
        System.out.println(new Solution().mySqrt(2147395599));


    }
}
