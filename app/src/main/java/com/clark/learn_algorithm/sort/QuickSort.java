package com.clark.learn_algorithm.sort;

/**
 * @author Clark
 * @description 快速排序
 * @date 2019/3/7
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] ints = new int[]{6, 2, 9, 18, 21, 8, 4, 5, 3, 7};

        quickSort(ints, 0, ints.length);
        printArray(ints);
    }

    private static void printArray(int[] args) {
        for (int i : args) {
            System.out.print(i + ",");
        }
    }

    private static int[] quickSort(int[] args, int left, int right) {
        if (left < right) {
            int pivot = getPivot(args, left, right);
            quickSort(args, left, pivot - 1);
            quickSort(args, pivot + 1, right);
        }

        return args;
    }

    /**
     * 找基准点，并把数组按照比基准点小的放在基准点左边，比基准点大的放在基准点右边进行排序。
     *
     * @param args
     * @param left
     * @param right
     * @return
     */
    private static int getPivot(int[] args, int left, int right) {
        int index = left + 1;
        for (int i = index; i < right; i++) {
            //遍历，寻找比基准点小的数
            if (args[i] < args[left]) {
                swap(args, i, index);
                index++;
            }
        }

        swap(args, left, index - 1);

        printArray(args);
        System.out.println("");
        return index - 1;
    }

    private static void swap(int[] args, int i, int j) {
        int temp = args[i];
        args[i] = args[j];
        args[j] = temp;

//        args[i] ^= args[j];
//        args[j] ^= args[i];
//        args[i] ^= args[j];
    }

}
