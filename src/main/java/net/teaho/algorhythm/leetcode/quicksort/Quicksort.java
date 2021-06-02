package net.teaho.algorhythm.leetcode.quicksort;

import java.util.Arrays;

/**
 * @author teaho2015@gmail.com
 * @date 2021-06
 * @since 1.0.0
 */
public class Quicksort {


    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);

    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    public int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo...i-1], a[i], a[i+1, hi]进行partition
        int i = lo, j = hi +1;

        Comparable v = a[lo];

        while (true) {
            while (a[++i].compareTo(v) < 0) if (i == hi) break;
            while (a[--j].compareTo(v) > 0) if (j == lo) break;

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }


    private void swap(Comparable[] nums, int index1, int index2) {
        Comparable tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        {
            Integer[] arr = new Integer[]{12, 15, 6, 7, 9, 1, 5, 32};
            new Quicksort().sort(arr);
            System.out.println(Arrays.toString(arr));

        }
    }

}
