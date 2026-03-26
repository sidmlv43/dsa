package fundamentals;

import java.util.Arrays;

public class BasicSorting {

    public static void main(String[] args) {
        int[] n = {5, 3, 4, 1, 9, 8, 7};
        bubbleSort(n);
        System.out.println(Arrays.toString(n));

        int[] n1 = {4, 2, 4, 1, 7, 8, 5, 10};
        selectionSort(n1);

        System.out.println(Arrays.toString(n1));

        int[] n2 = {5, 3, 2, 1};
        insertionSort(n2);

        System.out.println(Arrays.toString(n2));

    }


    /**
     *
     * Bubble Sort: A simple sorting algorithm that repeatedly steps through the list,
     * compares adjacent elements, and swaps them if they are in the wrong order.
     * This process repeats until the largest unsorted element "bubbles up" to its correct position at the end of the array.
     *
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
        }

    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }



    public static void insertionSort(int[] arr) {


        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = cur;
        }

    }
}
