package service;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayWithPrimes {
    private int lowerBound;
    private int upperBound;
    private List<int[]> arrays = new ArrayList<int[]>();
    private int[] commonExclusions;
    private int largestPrime = 0;

    public PlayWithPrimes(int numberOfArrays, int arrayLength, int lowerBound, int upperBound) throws Exception {
        for (int i = 0; i < numberOfArrays; ++ i) {
            arrays.add(ArrayUtils.generateRandomIntArray(arrayLength, lowerBound, upperBound));
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
//        this.commonExclusions = ArrayUtils.getCommonIntArrayExclusions(arrays, lowerBound, upperBound);
//        this.largestPrime = ArrayUtils.getIntArrayLargestPrime(commonExclusions);
    }

    public List<int[]> getArrays() {
        for (int i = 0; i < arrays.size(); ++ i) {
            System.out.printf("array %d: %s\n", i ,Arrays.toString(this.arrays.get(i)));
        }
        return this.arrays;
    }

    private void findCommonExclusions(){
        this.commonExclusions = ArrayUtils.getCommonIntArrayExclusions(arrays, lowerBound, upperBound);
    }

    public int[] getCommonExclusions() {
        if (this.commonExclusions == null)
            findCommonExclusions();
        System.out.printf("The common exclusions are %s\n", Arrays.toString(this.commonExclusions));
        return this.commonExclusions;
    }

    private int findLargestPrime(){
        this.largestPrime = ArrayUtils.getIntArrayLargestPrime(commonExclusions);
        return this.largestPrime;
    }

    public void getLargestPrime() {
        if (this.largestPrime == 0) {
            if (this.commonExclusions == null)
                findCommonExclusions();
            findLargestPrime();
        }
        if (this.largestPrime == -1) {
            System.out.print("There are no primes excluded!\n");
        } else {
            System.out.printf("The largest excluded prime is %d!\n", this.largestPrime);
        }
    }

}
