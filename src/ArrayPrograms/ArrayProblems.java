package ArrayPrograms;

import java.util.*;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] n = {1, 4, 2, 99, 1, 0};
        System.out.println(findMax(n));
        System.out.println(findSecondMax(n));
        System.out.println(isSorted(n));
        int[] sorted = {1, 2, 3, 4, 5, 99};
        System.out.println(isSorted(sorted));

        int[] duplicates = {1, 1, 1, 1, 2, 4, 4, 5, 5, 9};
        System.out.println(removeDuplicates(duplicates));

        leftRotate(sorted);
        System.out.println(Arrays.toString(sorted));

        leftRotateByKPlaces(sorted, 2);

        int[] arr = {1, 2, 3, 4, 5};
        rotateByKPlace(arr, 2, "left");
        System.out.println(Arrays.toString(arr));


        int[] zeroes = {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 12, 13, 11, 0};

        moveZeroesToEnd(zeroes);
        System.out.println(Arrays.toString(zeroes));

        int[] a = {1, 2, 4, 7, 10};
        int[] b = {1, 3, 5, 6, 8, 9};

        List<Integer> aUnionB = findUnion(a, b);

        System.out.println(aUnionB);
        int[] x = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(findMissing(x));

        int[] ones = {0, 0, 1, 1, 0, 1, 1, 1};
        System.out.println(countMaxConsecutive1(ones));

        int[] arr1 = {1, 2, 1, 2, 4};

        System.out.println(findUnique(arr1));

        // 14
        int[] n1 = {8, 6, 4, 7, 1, 2};
        System.out.println(maxSubArrayWithKSum(n1, 14));

        int[] n2 = {3, 4, 8, 9, 11, 14};
        twoSum(n2, 15);

        int[] n3 = {9, -3, 3, -1, 6, -5};
        int ans = maxSubArrayWithZeroSum(n3);
        System.out.println();
        System.out.println("ans = " + ans);

        int[] n4 = {0, 1, 2, 0, 0, 2, 2, 2};
        sortZeroesOnesAndTwos(n4);
        System.out.println(Arrays.toString(n4));

        int[] n5 = {1, 1, 0, 0, 1};
        System.out.println(majorityElement(n5));

        int[] n6 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadanesAlgo(n6));
        printMaxSumSubArray(n6);

    }

    public static int findMax(int[] arr) {
        int n = arr.length;

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int findSecondMax(int[] arr) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {

            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j < max) {
                secondMax = j;
            }

        }

        return secondMax;
    }

    public static boolean isSorted(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }


    public static List<Integer> removeDuplicates(int[] arr) {
        List<Integer> uniques = new ArrayList<>();

        int i = 0;
        uniques.add(arr[0]);

        for (int j = 1; j < arr.length; j++) {
            if(arr[j] != uniques.get(i)) {
                uniques.add(arr[j]);
                i++;
            }
        }

        return uniques;
    }


    public static void leftRotate(int[] arr) {
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }

        arr[arr.length - 1] = temp;
    }


    @SuppressWarnings("all")
    public static void leftRotateByKPlaces(int[] arr, int k) {
        int n = arr.length;

        List<Integer> temp = new ArrayList<>();

        int i = 0, j = 0;

        while (i < k) {
            temp.add(arr[i++]);
        }


        for (; i < n; i++) {
            arr[i - k] = arr[i];
        }

        for (int m = n - k; m < n; m++) {
            arr[m] = temp.get(j++);
        }
    }


    public static void rotateByKPlace(int[] arr, int k, String direction) {

        final int n = arr.length;

        if (n == 0 || k == 0) return;

        k = k % n;


        if (direction.equalsIgnoreCase("left")) {
            reverse(arr, 0, n - 1);
            reverse(arr, 0, n - k - 1);
            reverse(arr, n - k, n - 1);
        }

        else if(direction.equalsIgnoreCase("right")) {
            reverse(arr, 0, n - 1);
            reverse(arr, 0, k - 1);
            reverse(arr, k, n - 1);
        }

    }


    public static void reverse(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, start + 1, end - 1);
    }

    public static void moveZeroesToEnd(int[] arr) {
        int n = arr.length;

        int i = 0;

        // Step 1 -  Find 1st 0

        while (i < n && arr[i] != 0) {
            i++;
        }

        if (i >= n) {
            return;
        }


        // Step 2- Once the First 0 is found, initialize another variable j with i + 1;
        int j = i + 1;

        while (j < n) {
            // Step 3 - loop from j to n - 1 and if arr[j] is not 0, then swap it with arr[i] and increase i by 1
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }

    }


    public static List<Integer> findUnion(int[] n1, int[] n2) {
        int m = n1.length;
        int n = n2.length;
        List<Integer> unionList = new ArrayList<>();

        int left = 0, right = 0;

        while (left < m && right < n) {
            if (n1[left] <= n2[right]) {
                // Check if it's a duplicate before adding
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != n1[left]) {
                    unionList.add(n1[left]);
                }
                if (n1[left] == n2[right]) right++; // Move both if they are equal
                left++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != n2[right]) {
                    unionList.add(n2[right]);
                }
                right++;
            }
        }

        // Cleanup loops with the same duplicate check
        while (left < m) {
            if (unionList.get(unionList.size() - 1) != n1[left]) unionList.add(n1[left]);
            left++;
        }
        while (right < n) {
            if (unionList.get(unionList.size() - 1) != n2[right]) unionList.add(n2[right]);
            right++;
        }

        return unionList;
    }

    public static int findMissing(int[] arr) {

        int n = arr.length;
        if(n < 3){
            throw new IllegalArgumentException("array size must be greater than or equals to 3");
        }
        int x = n + 1;

        int expectedSum = (x * (x + 1)) / 2;
        int actualSum = Arrays.stream(arr)
                .reduce(0, Integer::sum);
        return expectedSum - actualSum;
    }

    public static int countMaxConsecutive1(int[] arr) {


        int count = 0;
        int maxCount = 0;

        for (int j : arr) {
            if (j == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;

    }

    public static int findUnique(int[]  arr) {

        int xorr = 0;

        for(int n: arr) {
            xorr ^= n;
        }

        return xorr;
    }

    public static int maxSubArrayWithKSum(int[] arr, int k) {
        int n = arr.length;

        int left = 0;

        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void twoSum(int[] arr, int k) {
        int n = arr.length;

        int start = 0, end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum > k) {
                end--;
            }
            else if (sum < k) {
                start++;
            }
            else {
                System.out.printf("%s + %s = %s", arr[start], arr[end], k);
                return;
            }
        }
    }


    public static int maxSubArrayWithZeroSum(int[] arr) {
        int n = arr.length;

        int sum = 0, maxi = 0;
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxi = i + 1;

            }
            else {
                if(mpp.containsKey(sum)) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {
                    mpp.put(sum, i);
                }
            }
        }

        return maxi;
    }


    public static void sortZeroesOnesAndTwos(int[] arr) {
        int n = arr.length;

        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                mid++;
                high--;
            }
        }

    }

    public static int majorityElement(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int el = -1;

        // Finding the possible majority element candidate.
        for (int k : arr) {
            if (cnt == 0) {
                el = k;
                cnt++;
            } else if (k == el) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // verifying if the possible candidate appears more than n/2 times
        int finalCnt = 0;
        for (int j : arr) {
            if (j == el) {
                finalCnt++;
            }
        }

        return finalCnt > n / 2 ? el : -1;
    }

    public static int kadanesAlgo(int[] arr) {
        int n = arr.length;
        int sum = 0, maxSum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void printMaxSumSubArray(int[] arr) {
        int n = arr.length;

        int sum = 0, maxSum = 0;
        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0){
                start  = i;
            }

            sum += arr[i];

            if (sum == 0) {
                start = i;
            }

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = ansStart; i <= ansEnd ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }


}
