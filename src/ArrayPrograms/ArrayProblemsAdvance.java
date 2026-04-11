package ArrayPrograms;
import fundamentals.AdvanceSorting;

import java.util.*;

import static ArrayPrograms.ArrayProblems.reverse;

@SuppressWarnings("all")
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

        int[] arr = {-1, 0, 2, 4, -2, 1, 3};
        int k = 2;

        System.out.println(countSubarrayWithKSum(arr, k));

        int[] arr1 = {1, 2, 5, 2, 4};
        int m = 6;
        twoSumUnsorted(arr1, m);

        int[] n1 = {-1, 0, 1, 2, -2};
        int[] n2 = {-1, 0, 1, 2, -1, -4};
        int[] n3 = {-2, 0, 1, 1, 2};


        System.out.println(threeSumBruteForce(n1));
        System.out.println(threeSumBetter(n1));
        System.out.println(threeSumOptimized(n1));
        System.out.println(threeSumBruteForce(n2));
        System.out.println(threeSumBetter(n2));
        System.out.println(threeSumOptimized(n2));
        System.out.println(threeSumBruteForce(n3));
        System.out.println(threeSumBetter(n3));
        System.out.println(threeSumOptimized(n3));
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

    public static int countSubarrayWithKSum(int[] arr, int k) {
        int n = arr.length;

        // initialize sum and count with 0
        int sum = 0, cnt = 0;


        // initialize a map which will store the prefix sum and the number of times the sum has occured.
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // initially the sum is 0, hence we will store (0, 1) in the prefixSum Map.
        prefixSumMap.put(0, 1);

        for (int i = 0; i < n; i++) {

            // add the number at the current index in sum.
            sum += arr[i];

            // if (sum - k) exists in the map, it means that we found subarrays, summing to k
            int remove = sum - k;

            // basically if sum - k exists, it means that k + sum - k = k

            if (prefixSumMap.containsKey(remove)) {
                // now we want to increase the count with the number of times we found sum - k
                cnt += prefixSumMap.get(remove);
            }

            // add the current prefix sum for future checks.
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);

        }

        return cnt;
    }

    public static void twoSumUnsorted(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> mpp = new HashMap<>();


        for (int i = 0; i < n; i++) {

            int req = k - arr[i];

            if (mpp.containsKey(req)) {
                System.out.println(req + ", " + arr[i]);
            }

            mpp.put(arr[i], i);

        }

    }


    public static Set<List<Integer>> threeSumBruteForce(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i +1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[k] + arr[j] == 0) {
                        List<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k]));
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                }
            }
        }

        return ans;
    }


    public static Set<List<Integer>> threeSumBetter(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i+ 1; j < n; j++) {

                int req = -(arr[i] + arr[j]);

                if (temp.contains(req)) {
                    List<Integer> seq = new ArrayList<>(List.of(arr[i], arr[j], req));
                    Collections.sort(seq);
                    ans.add(seq);
                }

                temp.add(arr[j]);
            }
        }

        return ans;
    }


    public static List<List<Integer>> threeSumOptimized(int[] arr) {
        int n = arr.length;
        // first sort the array
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++;
                }

                else if (sum > 0) {
                    k--;
                }

                else {
                    ans.add(new ArrayList<>(List.of(arr[i], arr[j], arr[k])));
                    j++;
                    k--;

                    // avoids dupliate check in arr[j] and arr[k]
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }

        }

        return ans;
    }

}
