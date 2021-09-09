package streams.learn_streams;

import java.util.stream.Stream;

public class Learn12 {
    public static void main(String[] args) {
        Stream.of(1,2,45,78,3,48,23,105,5,15)
                .map(x -> x+1)
                .forEach(System.out::println);
    }
}
