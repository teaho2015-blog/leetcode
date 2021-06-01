package net.teaho.algorhythm.leetcode.alg004findMedianSortedArrays;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 *解法：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * <br/>
 * 重点理解切分公式(i + j = m - i  + n - j)和奇偶切分融合
 *
 * <br/>时间：O(log（min（m，n））
 *
 * <br/>空间：O(1)
 *
 */
public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            //i 需要增大
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
            }
            // i需要减小
            else if (i != 0 && j != n && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {

                // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                //如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;

            }


        }
        return 0.0;

    }

    public static void main(String[] args) {
        {
            System.out.println(new Solution()
                .findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

        }

        {
            System.out.println(new Solution()
                .findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

        }


    }
}
