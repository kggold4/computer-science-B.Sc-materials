package streams.learn_streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn15 {
    public static void main(String[] args) {
        String a1 = Stream.of("Hello", "World")
                .collect(Collectors.joining());
        System.out.println("First join is: " + a1);

        String a2 = Stream.of("Hello", "World")
                .collect(Collectors.joining(" - "));
        System.out.println("Second join is: " + a2);

        String a3 = Stream.of("Hello", "World", "Keren")
                .collect(Collectors.joining(" - ", "start ", " end"));
        System.out.println("Third join is: " + a3);
    }
}
