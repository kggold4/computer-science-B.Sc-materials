package theads;

public class RunnableDemo implements Runnable {

    // when we create and start a thread the run function
    // is the function that will run
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // the class
        Runnable r0 = new RunnableDemo();

        // the thread for using the class
        Thread t0 = new Thread(r0);
        t0.setName("t0");
        t0.start();
    }
}
