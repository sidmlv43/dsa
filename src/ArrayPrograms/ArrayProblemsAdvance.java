package ArrayPrograms;
import java.util.Arrays;

import static ArrayPrograms.ArrayProblems.reverse;

public class ArrayProblemsAdvance {

    public static void main(String[] args) {
        int[] n = {1, 2, 5, 3, 4};
        nextPermutation(n);
        nextPermutation(n);
        System.out.println(Arrays.toString(n));
    }

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;

        // Step 1. Find the longest prefix by finding the dip point or the break point.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        // if no dip point found, reverse the array.

        if (idx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2. swap the dip point with the next greater element (from the suffix, not from prefix)

        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        // Step 3. reverse the suffix;

        reverse(arr, idx + 1, n - 1);
    }


}
