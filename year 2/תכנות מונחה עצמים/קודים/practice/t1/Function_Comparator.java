package practice.t1;

import java.util.Comparator;

public class Function_Comparator implements Comparator<function> {

    private double x0;

    public Function_Comparator(double x0) {
        this.x0 = x0;
    }

    @Override
    public int compare(function f1, function f2) {
        double a = f1.f(x0);
        double b = f2.f(x0);
        if(a == b) return 0;
        else if(a > b) return 1;
        else return -1;
    }
}
