package streams.learn_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn6 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("yes", "no", "hello", "goodbye", "none");
        Stream s1 = myList.stream();
        Stream s2 = s1.sorted();

        // in reverse order
        // Stream s2 = s1.sorted(Comparator.reverseOrder());
        List<String> sortedList = (List<String>)(s2.collect(Collectors.toList()));
        for(String item : sortedList) {
            System.out.println(item);
        }
    }
}
