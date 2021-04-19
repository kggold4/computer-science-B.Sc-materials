package theads;

public class ThreadExtends extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(i < 1000) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println("num: " + i + ", Thread " + getName());
            if(i == 100) {
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        ThreadExtends t0 = new ThreadExtends();
        ThreadExtends t1 = new ThreadExtends();
        t0.start();
        t1.start();
    }
}
