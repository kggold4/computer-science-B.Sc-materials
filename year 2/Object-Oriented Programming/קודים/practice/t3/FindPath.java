package practice.t3;

public class FindPath extends Thread {

    private static String password = "89654128";
    private String current_password;
    private static int min = 0, max = 1000*1000*100, start, end;
    public static int LENGTH = 8;

    public FindPath(int start, int end) {
        this.current_password = null;
        this.start = start;
        this.end = end;
    }

    public static boolean testPass(String s) {
        return s.equals(password);
    }

    public static String findPass() {
        int ind = min;
        while(ind < max) {
            String test = getStringFromNum(ind, LENGTH);
            if(testPass(test)) return test;
            ind++;
        }
        return null;
    }

    public static String getStringFromNum(int i, int len) {
        String ans = "" + i;
        while(ans.length() < len) {
            ans = "0" + ans;
        }
        return ans;
    }

    public String getPassword() {
        return this.current_password;
    }

    @Override
    public void run() {
        int ind = this.start;
        while(ind < this.end) {
            String test = FindPath.getStringFromNum(ind, FindPath.LENGTH);
            if(FindPath.testPass(test)) {
                System.out.println(this.getName());
                current_password = test;
            }
            ind++;
        }
    }

    public static void main(String[] args) {

        FindPath t0 = new FindPath(0, max / 3);
        FindPath t1 = new FindPath(max / 3, (int)(max / 1.5));
        FindPath t2 = new FindPath((int)(max / 1.5), max);

        t0.start();
        t1.start();
        t2.start();

        try {
            t0.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("password 1: " + t0.getPassword());
        System.out.println("password 2: " + t1.getPassword());
        System.out.println("password 3: " + t2.getPassword());
    }
}