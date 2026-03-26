package ArrayPrograms;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] n = {1, 4, 2, 99, 1, 0};
        System.out.println(findMax(n));
        System.out.println(findSecondMax(n));
        System.out.println(isSorted(n));
        int[] sorted = {1, 2, 3, 4, 5, 99};
        System.out.println(isSorted(sorted));
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

}
