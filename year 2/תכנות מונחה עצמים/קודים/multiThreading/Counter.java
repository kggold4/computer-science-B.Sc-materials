package multiThreading;

public class Counter {
    public int count; // java Thread safe Integer

    public Counter() {
        this.count = 0;
    }

    public synchronized void increment() {
        count++;
    } // no need to sync due to use of AtomicInteger

    public int getCount() {
        return count;
    }
}