package com.clark.learn_algorithm.sort;

/**
 * @author Clark
 * @description 冒泡算法
 * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3、针对所有的元素重复以上的步骤，除了最后一个；
 * 4、重复步骤1~3，直到排序完成。
 * @date 2019/3/7
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] ints = new int[]{6, 2, 9, 18, 21, 8, 4, 5, 3, 7};

        bubbleSort(ints);
        printArray(ints);
    }

    private static void printArray(int[] args) {
        for (int i : args) {
            System.out.print(i + ",");
        }
    }

    private static void bubbleSort(int[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
    }

    private void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

}
