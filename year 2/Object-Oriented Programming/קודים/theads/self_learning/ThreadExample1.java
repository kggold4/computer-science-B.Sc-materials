package theads.self_learning;

public class ThreadExample1 {

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("thread start");
            System.out.println("thread end");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
