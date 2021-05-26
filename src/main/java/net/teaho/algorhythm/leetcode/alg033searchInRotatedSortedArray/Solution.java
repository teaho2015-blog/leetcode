package net.teaho.algorhythm.leetcode.alg033searchInRotatedSortedArray;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>
 * <p>
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 * <p>
 * 时间复杂度： O(logn)，其中 nn 为 nums 数组的大小。整个算法时间复杂度即为二分查找的时间复杂度 O(logn)。
 * 空间~ O(1)
 */
public class Solution {

    public int search(int[] nums, int target) {

        int len = nums.length;

        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int lf = 0;
        int rt = len - 1;
        while (lf <= rt) {
            int mid = (rt + lf + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lf] <= nums[mid]) {
                if (nums[lf] <= target && target < nums[mid]) {
                    rt = mid - 1;
                } else {
                    lf = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[rt]) {
                    lf = mid + 1;
                } else {
                    rt = mid - 1;
                }

            }
        }


        return -1;
    }


    public static void main(String[] args) {
        {
            int[] arr = new int[]{4,5,6,7,0,1,2};
            System.out.println(new Solution().search(arr, 0));
        }
        {
            int[] arr = new int[]{4,5,6,7,0,1,2};
            System.out.println(new Solution().search(arr, 3));
        }
        {
            int[] arr = new int[]{1};
            System.out.println(new Solution().search(arr, 0));
        }
        {
            int[] arr = new int[]{1,3};
            System.out.println(new Solution().search(arr, 3));
        }
        {
            int[] arr = new int[]{5,1,3};
            System.out.println(new Solution().search(arr, 3));
        }

    }
}
