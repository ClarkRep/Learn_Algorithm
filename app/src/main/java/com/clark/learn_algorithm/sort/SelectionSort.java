package com.clark.learn_algorithm.sort;

/**
 * @author
 * @description
 * @date 2019/3/7
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] ints = new int[]{6, 2, 9, 18, 21, 8, 4, 5, 3, 7};

        selectionSort(ints);
        printArray(ints);
    }

    private static void printArray(int[] args) {
        for (int i : args) {
            System.out.print(i + ",");
        }
    }

    private static void selectionSort(int[] args) {
        int minIndex;
        int temp;
        for (int i = 0; i < args.length; i++) {
            minIndex = i;
            for (int j = i; j < args.length; j++) {
                if (args[minIndex] > args[j]) {
                    minIndex = j;
                }
            }

            temp = args[i];
            args[i] = args[minIndex];
            args[minIndex] = temp;
        }
    }
}
