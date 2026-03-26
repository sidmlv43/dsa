package fundamentals;

import java.util.Arrays;

public class AdvanceSorting {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 10, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {4, 3, 0, 1, 9, 7};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

    }

    public static void mergeSort(int[] arr, int si, int ei) {

        if (si >= ei) return;

        int mid = (si + ei) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid +1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];

        int left = si;
        int right = mid + 1;

        int k = 0;

        while (left <= mid && right <= ei) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            }

            else {
                temp[k++] = arr[right++];
            }

        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= ei) {
            temp[k++] = arr[right++];
        }

        // Copy temp in original
        for (int l = si; l <= ei; l++) {
            arr[l] = temp[l - si];
        }

    }


    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) return;
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }


    public static int partition(int[] arr, int si, int ei) {

        int pivot = arr[ei];
        int i = si - 1;


        for (int j = si; j <= ei; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

}
