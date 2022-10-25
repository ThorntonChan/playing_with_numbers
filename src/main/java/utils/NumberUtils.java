package utils;

import java.util.Random;

public class NumberUtils {
    public static int getRandomInt(int lowerBound, int upperBound){
        if (lowerBound == upperBound)
            return lowerBound;
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + lowerBound;
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
}
