package stream.learn_streams;

import java.util.function.Function;

public class Learn4 {

    public static Function<Integer, Integer> getFun(Function<Integer, Integer> inputFun) {
        return x -> inputFun.apply(x+2);
    }

    public static void main(String[] args) {
        System.out.println(getFun(x -> x*3).apply(4));
    }
}
