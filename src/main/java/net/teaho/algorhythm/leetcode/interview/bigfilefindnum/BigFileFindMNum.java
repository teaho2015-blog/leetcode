package net.teaho.algorhythm.leetcode.interview.bigfilefindnum;

import sun.nio.ch.FileChannelImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>在40亿条数字中(存在文件中)，找出前M个最大的数字
 * <p>乐信业务中台二面面试题
 *
 * <p>思路：利用小根堆去维护最大的M个数字
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class BigFileFindMNum {


    public Integer[] maxNum(String fileName, int m) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName));
            for (; ; ) {
                String s = bufferedReader.readLine();
                if (s == null) {
                    break;
                }
                int value = Integer.parseInt(s);
                if (priorityQueue.peek() < value) {
                    priorityQueue.add(value);
                    priorityQueue.poll();
                }
            }
        } catch (IOException e) {
            //TBD
            e.printStackTrace();
        }

        return priorityQueue.toArray(new Integer[]{});
    }


}
