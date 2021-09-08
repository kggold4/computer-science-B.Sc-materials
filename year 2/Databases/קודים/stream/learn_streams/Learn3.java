package stream.learn_streams;

public class Learn3 {

    interface IntOps {
        int unaryOp(int a);
    }

    public static void main(String[] args) {
        IntOps increment = (a -> a + 1);
        System.out.println(increment.unaryOp(5));
    }
}
