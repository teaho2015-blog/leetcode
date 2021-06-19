package net.teaho.algorhythm.leetcode.interview.bigfilefindnum;

/**
 * <p>在一个文件中含有40亿条数字（32位）中，找出一个不存在的数据（或者说如何判断某个数字是否存在）
 * <p>场景是：文件很大，内存只有几百k
 * <p>腾讯面试题，也是《编程珠玑》中的问题
 *
 * <p> 思路：二分查找，并切分文件，文件按照最大的位开始分类，最大位为0的数字放在一个文件，为1的放在另一个文件。
 * 对第一次切分的文件做切分：第二位为0的放一个文件，第二位1的放一个文件，依次执行，最终找到目标结果。
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class BigFileFindNotExistNum {


    public static void main(String[] args) {

    }


}
