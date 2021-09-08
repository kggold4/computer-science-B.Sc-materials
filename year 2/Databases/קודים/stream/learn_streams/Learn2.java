package stream.learn_streams;

import java.util.Arrays;

public class Learn2 {

    public static void main(String[] args) {
        int[] a = {1,2,3,6,5,4,78,9,6,5,1,2,3};
        double sum = Arrays.stream(a).filter(x -> x > 5).sum();
        System.out.println("sum is: " + sum);
    }
}
