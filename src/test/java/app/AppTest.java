package app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.PlayWithPrimes;

import java.util.List;

public class AppTest extends TestCase {

    public AppTest(String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    public void testPlayingWithPrimes() throws Exception {
        PlayWithPrimes newNumbersGame = new PlayWithPrimes(3, 15,0, 50);
//        newNumbersGame.getArrays();
        newNumbersGame.getAvailableNumbers();
//        newNumbersGame.getLargestPrime();
    }
    public void testConstructorGeneration() throws Exception {
        PlayWithPrimes newGame = new PlayWithPrimes(400, 2, 0, 50);
        List<int[]> arrays = newGame.getArrays();
        assertEquals(400, arrays.size());
        for (int[] array : arrays)
            assertEquals(2, array.length);
    }
    public void testConstructorGenerationBounds() throws Exception {
        PlayWithPrimes newGame = new PlayWithPrimes(3, 10, 0, 0);
        List<int[]> arrays = newGame.getArrays();
        for (int[] array : arrays){
            for (int num : array) {
                assertEquals(0, num);
            }
        }
        newGame = new PlayWithPrimes(3, 20, 99, 105);
        arrays = newGame.getArrays();
        for (int[] array : arrays){
            for (int num : array) {
                assertTrue(num >= 99 && num <= 105);
            }
        }
        try {
            new PlayWithPrimes(3, 20, -1, -5);
        } catch (Exception e) {
            return;
        }
        fail("Expected 'Cannot generate array with inverted bounds!' Exception");
    }
}
