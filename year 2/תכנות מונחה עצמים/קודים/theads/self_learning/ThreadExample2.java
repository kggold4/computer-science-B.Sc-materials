package theads.self_learning;

public class ThreadExample2 {

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable start");
            System.out.println("MyRunnable end");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
