package theads.self_learning;

public class ThreadExample3 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("anonymousRunnable start");
            System.out.println("anonymousRunnable end");
        };

        Thread thread = new Thread((runnable));
        thread.start();
    }
}