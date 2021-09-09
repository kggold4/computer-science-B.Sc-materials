package streams.learn_streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Learn18 {
    public static void main(String[] args) {
        Arrays.asList("camel", "you", "apple", "banana", "me")
                .stream().map(a -> a+a)
                .filter(a -> a.length() >= 7)
                .sorted()
                .forEach(System.out::println);
    }
}
