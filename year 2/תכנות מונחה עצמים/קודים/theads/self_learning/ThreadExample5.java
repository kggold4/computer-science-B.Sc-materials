package theads.self_learning;

public class ThreadExample5 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadName + " is finished");
        };

        Thread thread = new Thread(runnable, "thread 1");
        thread.start();

    }

}
