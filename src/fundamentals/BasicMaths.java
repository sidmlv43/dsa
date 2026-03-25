package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class BasicMaths {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(countDigitBruteForce(n));
        System.out.println(countDigitOptimal(n));

        int x = 123;
        System.out.println(reverseNumber(x));

        System.out.println("---------------------------------");
        printFactorsBruteForce(54);

        System.out.println("===============================");
        List<Integer> factors = getFactors(90);
        System.out.println(factors);

        System.out.println(isPrime(91));


        System.out.println(gcdBruteForce(12, 18));

        System.out.println(gcdOptimal(12, 18));

        System.out.println(lcm(12, 18));
    }

    public static int countDigitBruteForce(int n) {

        if (n == 0) return 1;

        if (n < 0) {
            n *= -1;
        }

        int count = 0;

        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }


    public static int countDigitOptimal(int n) {
        // 1. Handle zero explicitly
        if (n == 0) return 1;

        // 2. Use Math.abs and long to prevent Integer.MIN_VALUE overflow
        // 3. Perform the log calculation
        return (int) (Math.log10(Math.abs((long) n)) + 1);
    }

    public static int reverseNumber(int n) {
        int rev = 0;

        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }

        return rev;
    }


    public static void printFactorsBruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }


    public static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        int sqr = (int)Math.sqrt(n);

        for (int i = 1; i <= sqr; i++) {
            if (n % i == 0) {
                factors.add(i);

                if (n % i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        return factors;
    }


    public static boolean isPrime(int n) {

        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        int sqr = (int) Math.sqrt(n);
        for (int i = 5; i <= sqr; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static int gcdBruteForce(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) return b;
        if (b == 0) return a;

        int min = Math.min(a, b);

        // The highest common factor will be smaller than or equals to the min of a and b.

        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }


        return 1;
    }



    public static int gcdOptimal(int a, int b) {
        // Euclidean's algo -> gcd(a, b) = gcd (b, a % b)

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }



    public static int lcm (int a, int b) {
        return (a * b) / gcdOptimal(a, b);
    }

}
