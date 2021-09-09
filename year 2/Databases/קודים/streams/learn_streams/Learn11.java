package streams.learn_streams;

import java.util.Arrays;
import java.util.List;

public class Learn11 {
    public static void main(String[] args) {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        // take the words that start with c
        // make them uppercase
        // sort order
        myList.stream().filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // print only the first element
        // ifPresent - if exist
        System.out.println("Second:");
        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
