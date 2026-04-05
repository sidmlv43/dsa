package ArrayPrograms;
import fundamentals.AdvanceSorting;

import java.util.*;

import static ArrayPrograms.ArrayProblems.reverse;

public class ArrayProblemsAdvance {

    public static void main(String[] args) {
        int[] n = {1, 2, 5, 3, 4};
//        nextPermutation(n);
//        nextPermutation(n);
//        System.out.println(Arrays.toString(n));
        int[] numbers = {16, 17, 4, 3, 5, 2};
        System.out.println(findLeaders(n));
        System.out.println(findLeaders(numbers));

        int[] sequence = {100, 101, 1, 3, 2, 99, 102};
        System.out.println(longestSubsequence(sequence));
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


    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static int longestSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        AdvanceSorting.quickSort(arr, 0, n - 1);

        // variable to track the last smaller element in the sequence.
        int lastSmaller = Integer.MIN_VALUE;

        // variable to store the current sequence length.
        int cnt = 0;

        // variable to store the longest sequence found.
        int longest = 1;

        // iterate through the given array.
        for (int i = 0; i < n; i++) {
            // Case 1. Current element is exactly 1 greater than the lastSmaller element -> part of the sequence
            if (arr[i] - 1 == lastSmaller) {
                // increase the current sequence length
                cnt++;
                // update the last smaller to the current element
                lastSmaller = arr[i];
            }

            // Case 2. Current element is not consecutive and not a duplicate
            else if (arr[i] != lastSmaller) {
                // Reset the counter to 1
                cnt = 1;
                // update the lastSmaller to current element
                lastSmaller = arr[i];
            }

            // Update the longest sequence length if the current length is higher
            longest = Math.max(longest, cnt);

        }

        return longest;
    }

    public static int longestConsecutiveSequenceOptimal(int[] arr) {
        int n = arr.length;

        // if the array is empty, return 0
        if (n == 0) return 0;

        int longest = 1;

        Set<Integer> integerSet = new HashSet<>();

        // step 1. add all the elements in integerSet
        for (int num: arr) {
            integerSet.add(num);
        }

        // step 2. loop through each element in the set.
        for (int i: integerSet) {

            // if the set does not contain i - 1, it means that the current number is a probable starting point of
            // a sequence.
            if (!integerSet.contains(i - 1)) {

                // initialize cnt with 1 to store current sequence length.
                int cnt = 1;

                // store the current element in x
                int x = i;


                // loop through the set again till we found x + 1;
                while (integerSet.contains(x + 1)) {
                    // update the x with x + 1
                    x = x + 1;
                    // increase the current sequence length
                    cnt++;
                }


                // update the longest sequence found.
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

}
