package fundamentals;

import java.util.HashMap;
import java.util.Map;

public class Hashing {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 9, 5, 2, 5, 9};

        countFrequencyBruteForce(arr);
        Map<Integer, Integer> freq = countFrequency(arr);
        System.out.println(freq);
    }

    public static void countFrequencyBruteForce(int[] arr) {

        for (int cur : arr) {
            int cnt = 0;
            for (int i : arr) {

                if (i == cur) cnt++;
            }

            System.out.println(cur + " " + cnt);
        }

    }


    public static Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i: arr) {
            freq.put(i, freq.getOrDefault(i, 1) + 1);
        }

        return freq;
    }

}
