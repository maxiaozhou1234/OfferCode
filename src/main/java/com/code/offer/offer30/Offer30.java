package com.code.offer.offer30;

import com.code.offer.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer30 {

    /*
    * 最小的k个数
    * 如输入：4,5,2,1,3,6,8,7,9 最小4个
    * 输出：1,2,3,4
     */
    public static void main(String[] args) {
        Offer30 test = new Offer30();

        test.getNumbers1(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 4);

        test.getNumbers2(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 0);
        test.getNumbers2(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 9);
        test.getNumbers2(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 7);
        test.getNumbers2(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 4);

        test.getNumbers3(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 7);
        test.getNumbers3(new int[]{4, 5, 2, 1, 3, 6, 8, 7, 9}, 4);
    }

    //方法1：排序后输出前几个
    private void getNumbers1(int[] array, int k) {

        System.out.println("input >> " + Arrays.toString(array) + " k=" + k);
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            System.out.println("input error");
            return;
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(array[i]).append(",");
        }
        if (sb.length() > 0)
            sb.delete(sb.length() - 1, sb.length());
        System.out.println(" |-- output >> " + sb.toString());

    }

    //方法2：快排思路，选中一个数排序后，左边都是比它小，右边都是比该数大
    //排序后index等于k则结束
    //若小于k，继续排(index,end]
    //若大于k，继续排序[start,index)
    private void getNumbers2(int[] array, int k) {

        System.out.println("input >> " + Arrays.toString(array) + " k=" + k);
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            System.out.println("input error");
            return;
        }

        Utils.initTime();
        int start = 0, end = array.length - 1;
        int index = -1;
        int kk = k - 1;
        while (index != kk) {
            index = partition(array, start, end, kk);
            if (index == kk) {
                break;
            } else if (index > kk) {
                end = index + 1;
                index = partition(array, start, end, kk);
            } else {
                start = index + 1;
                index = partition(array, start, end, kk);
            }
        }

        Utils.timeConsuming();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(array[i]).append(",");
        }
        if (sb.length() > 0)
            sb.delete(sb.length() - 1, sb.length());
        System.out.println(" |-- output >> " + sb.toString());

    }

    private int partition(int[] array, int start, int end, int k) {

        int t = array[end];
        array[end] = array[k];
        array[k] = t;

        int index = start - 1;
        for (int i = start; i < end; i++) {

            if (array[i] < array[end]) {
                index++;
                if (index != i) {
                    t = array[index];
                    array[index] = array[i];
                    array[i] = t;
                }
            }
        }

        index++;
        t = array[index];
        array[index] = array[end];
        array[end] = t;

        return index;
    }

    //方法3：使用堆排序
    private void getNumbers3(int[] array, int k) {
        System.out.println("input >> " + Arrays.toString(array) + " k=" + k);
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            System.out.println("input error");
            return;
        }

        Utils.initTime();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (queue.size() != k) {
                queue.offer(array[i]);
            } else if (queue.peek() > array[i]) {
                queue.poll();
                queue.offer(array[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll()).append(",");
        }
        if (sb.length() > 0)
            sb.delete(sb.length() - 1, sb.length());
        System.out.println(" |-- output >> " + sb.toString());

        Utils.timeConsuming();
    }
}
