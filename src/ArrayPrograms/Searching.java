package ArrayPrograms;

public class Searching {

    public static void main(String[] args) {
        int[] n = {4, 1, 2, 39, 19,};

        int[] n1 = {1, 2, 3, 6, 7, 9, 13, 17, 19, 21, 22};

        System.out.println(linearSearch(n, 2));
        System.out.println(binarySearch(n1, 21));
    }


    public static int linearSearch(int[] arr, int key) {
        for(int i = 0; i < arr.length; i ++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int binarySearch(int[] arr, int key) {
        int n = arr.length;


        int start = 0;
        int end = n - 1;


        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }


        return -1;

    }
}
