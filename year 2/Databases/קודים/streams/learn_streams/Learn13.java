package streams.learn_streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn13 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> a = Stream.of(1,2,45,78,3,48,23,105,5,15)
                .collect(Collectors.groupingBy(x -> x % 10));
        for(var entry : a.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
