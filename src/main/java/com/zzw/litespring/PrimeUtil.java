package com.zzw.litespring;

import java.util.Arrays;

/**
 * Author: Daydreamer
 * Date:2019/4/13
 */
public class PrimeUtil {
    public static int[] getPrimes(int max) {
        if (max <= 2) {
            return new int[]{};
        }
        int[] primes = new int[max];
        int count = 0;
        for (int num = 2; num < max; num++) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
        }
        primes = Arrays.copyOf(primes, count);
        return primes;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
