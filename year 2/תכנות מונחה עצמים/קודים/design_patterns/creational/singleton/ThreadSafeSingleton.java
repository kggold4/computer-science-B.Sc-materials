package design_patterns.creational.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if(instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
