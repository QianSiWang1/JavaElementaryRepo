package sort;

import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2,5,4,5,6,7,1224,6,12,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if (arr[j] > temp) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
            }
        }
    }

}
