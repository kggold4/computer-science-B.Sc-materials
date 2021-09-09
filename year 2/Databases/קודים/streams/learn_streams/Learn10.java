package streams.learn_streams;

import java.util.Arrays;

public class Learn10 {
    public static void main(String[] args) {
        int[] arr = {1,2,45,78,3,48,23,105,5,15};

        // print the numbers that less than 10
        System.out.println("Less than 10:");
        Arrays.stream(arr).filter(s -> (s < 10))
                .forEach(System.out::println);

        // print each number in modulus 10
        System.out.println("Modulus 10:");
        Arrays.stream(arr).map(s -> s % 10)
                .forEach(System.out::println);

        // print the number in sorted order
        System.out.println("Sorted List:");
        Arrays.stream(arr).sorted()
                .forEach(System.out::println);
    }
}
