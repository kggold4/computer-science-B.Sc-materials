package practice.t2;

import java.util.Date;

public class q3 extends Thread {

    private long dt = 100;// delta time in mili seconds
    private long time = 0;// time from start
    private double MAX_TIME = 50*1000; // 50 seconds in mili seconds.

    private MyFrame window;
    private Path path;

    public q3(MyFrame window, Path path) {
        this.window = window;
        this.path = path;
    }

    public void run() {
        long last_time = new Date().getTime();
        while(time <MAX_TIME) {
            long now = new Date().getTime();
            if(now>=last_time + dt) {
                time = time + (now-last_time);
                last_time = now;
                Point p = path.getPointInTime(time);
                window.update(p);
                window.repaint();
            }
        }
    }

    public static void main(String[] args) {

        MyFrame window = new MyFrame().show(); // GUI
        Path path = new Path("path.txt");

        q3 q = new q3(window, path);
        try {
            q.start();
            q.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class Path {
    public Path(String s) {}
    public Point getPointInTime(long g) { return null; }
}