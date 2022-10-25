package app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import utils.ArrayUtils;
import utils.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberUtilsTest extends TestCase {

    public NumberUtilsTest(String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( NumberUtilsTest.class );
    }

    public void testPrimeChecker() {
        assertFalse(NumberUtils.isPrime(-100));
        assertFalse(NumberUtils.isPrime(-2));
        assertFalse(NumberUtils.isPrime(-1));
        assertFalse(NumberUtils.isPrime(0));
        assertFalse(NumberUtils.isPrime(1));
        assertFalse(NumberUtils.isPrime(4393));
        assertTrue(NumberUtils.isPrime(2));
        assertTrue(NumberUtils.isPrime(3));
        assertTrue(NumberUtils.isPrime(5));
        assertTrue(NumberUtils.isPrime(7));
        assertTrue(NumberUtils.isPrime(11));
        assertTrue(NumberUtils.isPrime(97));
        assertTrue(NumberUtils.isPrime(4409));
    }

    public void testRandomNumberGenerator(){
        assertTrue(NumberUtils.getRandomInt(8,8) == 8);
        int i = NumberUtils.getRandomInt(9,10);
        assertTrue(i == 9 || i == 10);
        try {
            i = NumberUtils.getRandomInt(11,10);
        } catch (IllegalArgumentException e){
            return;
        }
        fail("Bounds were negative");
    }

}
