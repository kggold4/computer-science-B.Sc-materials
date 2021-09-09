package streams.learn_streams;

import java.util.concurrent.Callable;

public class Learn5 {
    public static void main(String[] args) throws Exception {
        Callable<Integer> printAndReturn7 = () -> {
            int x = 7;
            System.out.println(x);
            return x;
        };
        System.out.println(printAndReturn7.call());
    }
}
