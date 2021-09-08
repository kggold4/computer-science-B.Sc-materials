package stream.learn_streams;

import java.util.Arrays;
import java.util.List;

public class Learn7 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("yes", "no", "hello", "goodbye", "none");
        myList.stream().sorted().forEach((a) -> System.out.println(a));
    }
}
