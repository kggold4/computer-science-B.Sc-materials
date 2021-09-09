package streams.learn_streams;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn14 {
    public static void main(String[] args) {
        IntSummaryStatistics a =
        Stream.of(1,2,45,78,3,48,23,105,5,15)
                .collect(Collectors.summarizingInt((x -> x)));

        System.out.println("Count is: " + a.getCount());
        System.out.println("Sum is: " + a.getSum());
        System.out.println("Min is: " + a.getMin());
        System.out.println("Max is: " + a.getMax());
        System.out.println("Average is: " + a.getAverage());
    }
}
