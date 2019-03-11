package com.clark.learn_algorithm.sort;

/**
 * @author Clark
 * @description
 * 插入排序
 * @date 2019/3/7
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] ints = new int[]{6, 2, 9, 18, 21, 8, 4, 5, 3, 7};

        insertSort(ints);
        printArray(ints);
    }

    private static void printArray(int[] args) {
        for (int i : args) {
            System.out.print(i + ",");
        }
    }

    private static void insertSort(int[] args) {
        for (int i = 1; i < args.length; i++) {
            for (int j = i; j > 0; j--) {
                if (args[j] < args[j - 1]) {
                    //快速交换两个数
                    args[j] ^= args[j - 1];
                    args[j - 1] ^= args[j];
                    args[j] ^= args[j - 1];
                }
            }
        }
    }
}
