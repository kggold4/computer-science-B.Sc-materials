package practice.t4;

public class Main {
    public static void main(String[] args) {
        Chat c = new Chat();
        Boy b = new Boy(c);
        Girl g = new Girl(c);

        b.start();
        g.start();
    }
}
