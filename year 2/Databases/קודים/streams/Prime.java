package streams;

import java.util.stream.IntStream;

public class Prime {

    private static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num <= 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i = i + 6) if(num % i == 0 || num % (i + 2) == 0) return false;
        return true;
    }

    public static void primes(int num) {
        IntStream.rangeClosed(0, num)
                .filter(n -> isPrime(n) == true && num % n == 0)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        primes(115);
    }
}
