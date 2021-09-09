package streams.learn_streams;

import java.util.Optional;
import java.util.stream.Stream;

public class Learn20 {
    public static void main(String[] args) {
        Optional<Integer> a = Stream.of(1,45,6).reduce((x, y) -> x+y);
        Integer a1 = a.get();
        System.out.println("First: " + a1);
        Optional<String> b = Stream.of("1","45","6").reduce((x,y) -> x + "," + y);
        String b1 = b.get();
        System.out.println("Second: " + b1);
        Integer c = Stream.of(1,45,6).reduce(0, (x,y) -> x+1, (x,y) -> x+y);
        System.out.println("Third: " + c);
    }
}
