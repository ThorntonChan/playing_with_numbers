package app;

import service.PlayWithPrimes;

public class App {
    public static void main( String[] args ) throws Exception {
        PlayWithPrimes newNumbersGame = new PlayWithPrimes(3, 15,0, 50);
        newNumbersGame.getArrays();
        newNumbersGame.getCommonExclusions();
        newNumbersGame.getLargestPrime();
    }
}
