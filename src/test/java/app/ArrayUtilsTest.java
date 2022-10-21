package app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilsTest extends TestCase {

    public ArrayUtilsTest(String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ArrayUtilsTest.class );
    }

    public void testGetCommonIntArrayExclusions() {
        // return must be in sorted order

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9};
        List<int[]> arrays = new ArrayList<>();
        arrays.add(arr);
        arrays.add(arr2);
        arr = ArrayUtils.getCommonIntArrayExclusions(arrays,0, 10);
        assertTrue(Arrays.equals(arr, new int[]{0, 10}));

        arr = new int[]{0,10};
        arr2 = new int[]{};
        arrays = new ArrayList<>();
        arrays.add(arr);
        arrays.add(arr2);
        arr = ArrayUtils.getCommonIntArrayExclusions(arrays,0, 10);
        assertTrue(Arrays.equals(arr, new int[]{1,2,3,4,5,6,7,8,9}));

        arr = new int[]{1,2};
        arr2 = new int[]{3,4};
        int[] arr3 = new int[]{5,6};
        arrays = new ArrayList<>();
        arrays.add(arr);
        arrays.add(arr2);
        arrays.add(arr3);
        arr = ArrayUtils.getCommonIntArrayExclusions(arrays,0, 10);
        assertTrue(Arrays.equals(arr, new int[]{0,7,8,9,10}));


    }
    public void testPrimeChecker() {
        assertFalse(ArrayUtils.isPrime(-100));
        assertFalse(ArrayUtils.isPrime(-2));
        assertFalse(ArrayUtils.isPrime(-1));
        assertFalse(ArrayUtils.isPrime(0));
        assertFalse(ArrayUtils.isPrime(1));
        assertFalse(ArrayUtils.isPrime(4393));
        assertTrue(ArrayUtils.isPrime(2));
        assertTrue(ArrayUtils.isPrime(3));
        assertTrue(ArrayUtils.isPrime(5));
        assertTrue(ArrayUtils.isPrime(7));
        assertTrue(ArrayUtils.isPrime(11));
        assertTrue(ArrayUtils.isPrime(97));
        assertTrue(ArrayUtils.isPrime(4409));
    }
    public void testLargestPrimeFinder() {
        int[] arr = new int[] {2,3,4,7,11,97,4393};
        assertEquals(97, ArrayUtils.getIntArrayLargestPrime(arr));
        arr = new int[]{8,64,1080,4999952};
        assertEquals(-1, ArrayUtils.getIntArrayLargestPrime(arr));
    }

}
