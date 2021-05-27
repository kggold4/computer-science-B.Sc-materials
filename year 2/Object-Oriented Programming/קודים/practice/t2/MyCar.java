package practice.t2;

import java.util.Date;

public class MyCar implements car {
    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean open(String key) {
        return false;
    }

    @Override
    public Date lastRun() {
        return null;
    }
}
