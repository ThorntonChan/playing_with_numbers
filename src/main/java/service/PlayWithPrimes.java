package service;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayWithPrimes {
    private final int lowerBound;
    private final int upperBound;
    private final List<int[]> arrays = new ArrayList<int[]>();
    private int[] availableNumbers;
    private int largestPrime = 0; //default = 0, none found = -1

    public PlayWithPrimes(int numberOfArrays, int arrayLength, int lowerBound, int upperBound) throws Exception {
        for (int i = 0; i < numberOfArrays; ++ i) {
            arrays.add(ArrayUtils.generateRandomIntArray(arrayLength, lowerBound, upperBound));
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public List<int[]> getArrays() {
        for (int i = 0; i < arrays.size(); ++ i) {
            System.out.printf("array %d: %s\n", i ,Arrays.toString(this.arrays.get(i)));
        }
        return this.arrays;
    }

    public int[] getAvailableNumbers() {
        if (this.availableNumbers == null)
            this.availableNumbers = ArrayUtils.getCommonIntArrayExclusions(arrays, lowerBound, upperBound);
        System.out.printf("The available numbers are %s\n", Arrays.toString(this.availableNumbers));
        return this.availableNumbers;
    }

    public int getLargestPrime() {
        if (this.largestPrime == 0) {
            if (this.availableNumbers == null)
                getAvailableNumbers();
            this.largestPrime = ArrayUtils.getLargestPrimeFromSortedArray(availableNumbers);
        }
        if (this.largestPrime == -1) {
            System.out.print("There are no primes excluded!\n");
        } else {
            System.out.printf("The largest excluded prime is %d!\n", this.largestPrime);
        }
        return this.largestPrime;
    }

}
