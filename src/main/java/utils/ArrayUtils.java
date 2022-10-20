package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayUtils {

    // exclusively static methods - must not be instatiated or overridden;

    public static int[] generateRandomIntArray(int size, int lowerBound, int upperBound) throws Exception {
        int[] arr = new int[size];
        if (upperBound < lowerBound) {
            throw new Exception("Cannot generate array with inverted bounds!");
        } else if (upperBound == lowerBound) {
            Arrays.fill(arr, lowerBound);
        } else {
            Random random = new Random();
            for (int i = 0; i < size; ++i) {
                arr[i] = random.nextInt(upperBound - lowerBound) + lowerBound;
                // using apache.commons for error handling arr[i] = RandomUtils.nextInt(lowerBound, upperBound);
            }
        }
        return arr;
    }

    public static int[] getCommonIntArrayExclusions(List<int[]> arrays, int lowerBound, int upperBound) {
        if (arrays == null || arrays.size() == 0)
            return new int[0];

        boolean[] presentInts = new boolean[upperBound - lowerBound + 1];
        for (int[] array : arrays) {
            for (int num : array) {
                presentInts[num] = true;
            }
        }
        List<Integer> commonExclusions = new ArrayList<Integer>();
        for (int i = 0; i < presentInts.length; ++i) {
            if (!presentInts[i])
                commonExclusions.add(i);
        }
        return commonExclusions.stream().mapToInt(i->i).toArray();
    }

    public static boolean isPrime(int n){
        if (n <= 1)
            return false;

        int maxTest = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= maxTest; ++ i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int getIntArrayLargestPrime(int[] arr) {
        // requires arr to be pre-sorted
        for (int i = arr.length - 1; i >= 0; -- i) {
            if (isPrime(arr[i]))
                return arr[i];
        }
        return -1;
    }
}
