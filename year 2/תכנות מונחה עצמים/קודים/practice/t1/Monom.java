package practice.t1;

public class Monom implements function {

    private double coe;
    private int pow;

    public Monom(double a, int b) {
        this.coe = a;
        this.pow = b;
    }
    public Monom(Monom ot) {
        this(ot.get_coefficient(), ot.get_power());
    }

    @Override
    public double f(double x) {
        return 0;
    }

    public double get_coefficient() {
        return this.coe;
    }

    public int get_power() {
        return this.pow;
    }

    public Monom derivative() {

        if(this.pow == 0) return new Monom(0, 0);
        else if(this.pow == 1) return new Monom(this.coe, 0);
        else {
            int coe = (int)this.coe * this.pow;
            int pow = this.pow - 1;
            return new Monom(coe, pow);
        }
    }
}
