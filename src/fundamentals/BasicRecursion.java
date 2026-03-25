package fundamentals;

import java.util.Arrays;
import java.util.List;

public class BasicRecursion {

    public static void main(String[] args) {
        printNTimes(4, 4);
        printNTimes("Hello World", 5);

        System.out.println("------------------------------------------");
        print1ToN(5);

        System.out.println("-------------------------------------------");

        printNTo1(5);

        System.out.println("--------------------------------------------");
        System.out.println(sumOfNNumbers(5));
        System.out.println("--------------------------------------------");
        System.out.println(factorial(5));

        Integer[] arr = {3, 4, 1};
        String[] strArr = {"Apple", "Pear", "Orange", "Kiwi", "Banana"};
        reverseArray(strArr, 0, strArr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(strArr));

        String s = "Racecar";
        System.out.println(isPalindrome(s, 0, s.length() - 1));

        System.out.println("========================================");
        System.out.println(fibonacci(4));

    }

    public static<T> void printNTimes(T x, int n) {
        if (n == 0) return;

        printNTimes(x, n-1);
        System.out.println(x);
    }

    public static void print1ToN(int n) {
        if (n == 0) return;

        print1ToN(n - 1);
        System.out.println(n);
    }

    public static void printNTo1(int n) {
        if (n == 0) return;

        System.out.println(n);
        printNTo1(n - 1);
    }

    public static int sumOfNNumbers(int n) {
        return n == 0 ? 0 : n + sumOfNNumbers(n - 1);
    }

    public static int factorial(int n) {
        return n <= 0 ? 1 : n * factorial(n - 1);
    }

    public static<T> void reverseArray(T[] arr, int i, int j) {
        if (i >= j) return;

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverseArray(arr, i + 1, j - 1);
    }


    public static boolean isPalindrome(String str, int i, int j) {
        if (i >= j) return true;

        return (str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) && isPalindrome(str, i + 1, j - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
