package utils;

import java.util.*;

public class ArrayUtils {

    // exclusively static methods - must not be instatiated or overridden;

    public static int[] generateRandomIntArray(int size, int lowerBound, int upperBound) throws Exception {
        int[] arr = new int[size];
        if (upperBound < lowerBound) {
            throw new Exception("Cannot generate array with inverted bounds!");
        } else if (upperBound == lowerBound) {
            Arrays.fill(arr, lowerBound);
        } else {
            for (int i = 0; i < size; ++i) {
                arr[i] = NumberUtils.getRandomInt(lowerBound, upperBound);
                // using apache.commons for error handling arr[i] = RandomUtils.nextInt(lowerBound, upperBound);
            }
        }
        return arr;
    }

    public static int[] getCommonIntArrayExclusions(List<int[]> arrays, int lowerBound, int upperBound) {
        if (arrays == null || arrays.size() == 0)
            return new int[0];

        Set<Integer> inclusions = new HashSet<>(); //preferred over boolean[] for non-deterministic space complexity
        for (int[] array : arrays) {
            for (int num : array) {
                inclusions.add(num);
            }
        }
        List<Integer> commonExclusions = new ArrayList<Integer>();
        for (int i = lowerBound; i <= upperBound; ++ i) { // guarantees sorted
            if (!inclusions.contains(i)){
                commonExclusions.add(i);
            }
        }
        return commonExclusions.stream().mapToInt(i->i).toArray();
    }

    public static int getLargestPrimeFromSortedArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; -- i) {
            if (NumberUtils.isPrime(arr[i]))
                return arr[i];
        }
        return -1;
    }
}
