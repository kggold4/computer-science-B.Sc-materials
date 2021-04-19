package practice.t2;

import java.util.Date;

public class MyCode implements car_code {

    private static final long MAX_TIME = 1000*60;
    private static final long TIME_OUT = 1000*60*15;
    private static final int MAX_ERR = 3;
    private car current_car;
    private long lastERR, lastOpen;
    private int errNum;

    public MyCode() {
        this.current_car = new MyCar();
        this.lastERR = 0;
        this.lastOpen = 0;
        this.errNum = 0;
    }

    @Override
    public boolean open(String key) {
        boolean ans = false;
        if(isOpen()) ans = true;
        if(!ans && canBeOpen()) {
            if(getCar().open(key)) {
                ans = true;
                errNum = 0;
                lastOpen = now();
            } else {
                this.errNum++;
                if(errNum >= MAX_ERR) {
                    this.lastERR = now();
                }
            }

        }

        return ans;
    }


    @Override
    public boolean isOpen() {

        // if the car is running
        if(getCar().isRunning()) return true;

        // current time - last open of the car < 15 minutes
        if(now() - lastOpen < TIME_OUT) return true;

        // cannot be open
        return false;
    }

    @Override
    public boolean canBeOpen() {
        boolean ans = false;
        if(isOpen()) ans = true;
        if(!ans && now() - this.lastERR > TIME_OUT) ans = true;
        return ans;
    }

    @Override
    public car getCar() {
        return null;
    }

    private long now() { return new Date().getTime(); }

}
