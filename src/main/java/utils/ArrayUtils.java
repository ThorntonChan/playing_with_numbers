package utils;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayUtils {

    public int[] generateRandomIntArray(int size, int lowerBound, int upperBound) throws Exception {
        if (upperBound < lowerBound)
            throw new Exception("Cannot generate array with inverted bounds!");
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = random.nextInt(upperBound - lowerBound) + lowerBound;
            // using apache.commons for error handling arr[i] = RandomUtils.nextInt(lowerBound, upperBound);
        }
        return arr;
    }

    public int[] getCommonIntArrayExclusions(List<int[]> arrays, int lowerBound, int upperBound) throws Exception {
        if (arrays == null || arrays.size() == 0)
            throw new Exception("No arrays were provided!");
        
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

}
