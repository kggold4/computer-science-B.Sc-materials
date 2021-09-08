package stream.learn_streams;

import java.util.Arrays;

public class Learn1 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 2, 1};
        int sum = Arrays.stream(a).sum();
        System.out.println("sum is: " + sum);
    }
}
