package streams.learn_streams;

import java.util.Optional;
import java.util.stream.Stream;

public class Learn19 {
    public static void main(String[] args) {
        Optional<Integer> x = Stream.of(1,45,6,23,8).reduce(Integer::sum);
        Integer y = x.get();
        System.out.println("Sum is: " + y);
    }
}
