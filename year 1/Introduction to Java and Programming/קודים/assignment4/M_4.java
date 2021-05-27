package assignment4;

/**
 *
 * Task 4, computer science, semester b 2020
 * @author Kfir Goldfarb - (id: 208980359)
 * @version 1.3
 * @see more two files for JUnit tests for all classes methods
 * JUnitMonom - testing Monom class methods
 * JUnitPolynom  - testing Polynom class methods
 *
 **/

//imports
import java.util.ArrayList;
import java.util.Scanner;


//main class for basic checking classes
public class M_4 {

    //main function
    public static void main(String args[]) {

        /*
            basic checks:
        */

        //create monoms
        Monom m1 = new Monom(5,3);
        Monom m2 = new Monom("-2.6x^6");
        Monom m3 = new Monom("-1");

        //create p1 polynom and add monoms
        Polynom p1 = new Polynom();
        p1.add(m1);
        p1.add(m2);
        p1.add(m3);

        //create p2 polynom with deep copy of p1 polynom
        Polynom p2 = new Polynom(p1);

        //output them
        System.out.println(p1);
        System.out.println(p2);

        //add m1 monom to check deep copy
        p1.add(m1);
        System.out.println(p1);
        System.out.println(p2);

        //multiply p1 polynom by p2 polynom
        p1.multiply(p2);
        System.out.println(p1);

        //output derivative of p2 polynom
        System.out.println(p2.derivative());

        //output p2 polynom area by integral from 1 to 6 by eps = 0.1;
        System.out.println(p2.area(1, 6, 0.1));

        //output cutting point in x axis in p2 polynom (checking from -10 to 10 by eps = 0.1)
        System.out.println(p2.root(-10, 10, 0.1));

        //if can't fint cutting point in x axis in p2 polynom
        System.out.println(p2.root(-10, -9, 0.1));
    }
}

/**
 *
 * This class represents a simple "Monom" of shape a*x^b,
 * where a is a real number and b none negative integer
 * see: https://en.wikipedia.org/wiki/Monomial
 * The class support simple operations as:
 * construction, value at x, derivative, add and multiply.
 * When constructor gets Monom as string, number of possible
 * shapes: String[] monoms = {"2", "-x","-3.2x^2","0"};
 */

class Monom {

    //nouns
    private double coeff;
    private int power;

    //main constructor
    //creates a monom
    public Monom(double coeff, int power) {

        this.coeff = coeff;
        this.power = power;

        if(this.power < 0) setPowerAgain();
    }

    //I create another method that set the power parameter to the monom again
    //this method is executing if monom power is lower than 0
    //the reason I write this as a method and not in the main constructor is because i need this checking loop also for the string constructor
    public void setPowerAgain() {
        Scanner powerInput = new Scanner(System.in);
        while(this.power < 0) {
            System.out.println("the power (n) of the monom is need to be grater or equal to 0.");
            System.out.print("insert the power (n) again: ");
            this.power = powerInput.nextInt();
        }
        powerInput.close();
    }

    //deep copy constructor
    //the deep copy is working because this is primitive variables and i can't add new statement here
    public Monom(Monom m) {
        this.coeff = m.coeff;
        this.power = m.power;
    }

    //creates a monom from string constructor
    public Monom(String s) {

        //if the monom is contains "x"
        if(s.contains("x") || s.contains("X")) {

            //split the string to coeff and power
            String[] charsSplit = new String[s.length()];
            charsSplit = s.split("x", 2);

            //define coeff
            //if string is start with -x
            if(charsSplit[0].equals("-")) {

                this.coeff = -1;

                //if string is start with +x
            } else if(charsSplit[0].equals("+")) {

                this.coeff = 1;

                //if coeff is not with "-" or "+"
            } else {

                //if x is with no coeff
                if(charsSplit[0].equals("")) {
                    this.coeff = 1;

                    //if coeff is a number
                } else {
                    this.coeff = Double.parseDouble(charsSplit[0]);
                }
            }

            //define power
            //if there is a definition of power in the string
            if(charsSplit[1].contains("^")) {

                //assign ^power to afterPowerSplitContent string
                String afterPowerSplitContent = charsSplit[1];

                //substring only the power number without "^"
                this.power = Integer.parseInt(afterPowerSplitContent.substring(1));

                //if the power is lower than 0
                if(this.power < 0) setPowerAgain();

                //if there not have a definition of power in the string
            } else {
                this.power = 1;
            }

            //if the monom string mot contains x
        } else {

            //if s string is empty
            if(s.equals("")) {
                this.coeff = 0;

                //if s string contain number
            } else {
                this.coeff = Double.parseDouble(s);
            }
        }

    }

    //tests if this a zero monom
    public boolean isZero() {
        if(this.coeff == 0) {
            return true;
        } else {
            return false;
        }
    }

    //tests if this monom is equal to m
    public boolean equals(Monom m) {
        if(this.coeff == m.coeff && this.power == m.power) {
            return true;
        } else {
            return false;
        }
    }

    //add m to this monom
    public void add(Monom m) {
        if(this.power == m.power) this.coeff = this.coeff + m.coeff;
    }

    //multiply this monom by m monom
    public void multiply(Monom m) {
        this.coeff = this.coeff * m.coeff;
        this.power = this.power + m.power;
    }

    //multiply m1 monom by m2 monom
    public Monom multiple(Monom m1, Monom m2) {
        Monom multiplyMonom = new Monom(m1.coeff * m2.coeff, m1.power + m2.power);
        return multiplyMonom;
    }

    //calculate the value of monom in point x
    public double f(double x) {
        return this.coeff * (Math.pow(x, this.power));
    }

    //compare two monoms
    public int compareTo(Monom m) {
        if(this.power < m.power) {
            return -1;
        } else if(this.power > m.power) {
            return 1;
        } else if(this.power == m.power && this.coeff == m.coeff) {
            return 0;
        } else {
            return 1;
        }
    }

    //compute a new monom which is the derivative of this monom
    public Monom derivative() {
        double newCoeff = this.coeff * this.power;
        int newPower = 1;
        if(this.power == 0) {
            newCoeff = 0;
            newPower = 1;
        } else {
            newPower = this.power = this.power - 1;
        }
        Monom derivativeMonom = new Monom(newCoeff, newPower);
        return derivativeMonom;
    }

    //returns string representing the value of Monom
    public String toString() {
        return "( " + this.coeff + " * X ^ " + this.power + " )";
    }

    //functions that helps me to sorting the polynom in polynon class by powers
    public int getPower() {
        return this.power;
    }

    public void setPower(int p) {
        this.power = p;
    }

    public double getCoeff() {
        return this.coeff;
    }

    public void setCoeff(double c) {
        this.coeff = c;
    }
}

/**
 *
 * This class represents a Polynom with add, multiply
 * functionality,
 * it also should support the following:
 * 1. Riemann's Integral:
 *    see https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values
 *   (currently support root only f(x)=0).
 * 3. Derivative.
 *
 */


class Polynom {

    //nouns
    private ArrayList<Monom> polynom;

    //empty default constructor
    public Polynom() {
        this.polynom = new ArrayList<Monom>();
    }

    //deep copy constructor
    public Polynom(Polynom p) {
        this.polynom = new ArrayList<>();
        for(int i = 0; i < p.polynom.size(); i++) {
            Monom newCopy = new Monom(p.polynom.get(i));
            this.add(newCopy);
        }
    }

    //add monom to polynom
    public void add(Monom m) {
        this.polynom.add(m);

        //sorting polynom monoms by powers
        sortByPower();
    }

    //add polynom to polynom
    public void add(Polynom p) {

        //define the new polynon that will contains the two polynoms
        ArrayList<Monom> newPolynom = new ArrayList<Monom>();

        //adding this polynom
        for(int i = 0; i < this.polynom.size(); i++) {
            newPolynom.add(this.polynom.get(i));
        }

        //adding p parameter polynom
        for(int i = 0; i < p.polynom.size(); i++) {
            newPolynom.add(p.polynom.get(i));
        }

        //assign the new polynom to this polynom
        this.polynom = newPolynom;

        //sorting polynom monoms by powers
        sortByPower();
    }

    //sorting polynom by power function - like bubble sorting
    public void sortByPower() {

        for(int i = 0; i < this.polynom.size(); i++) {
            for(int j = i; j < this.polynom.size() - 1; j++) {

                //checking if monom i power is < monom i + 1 power
                if(this.polynom.get(j).getPower() < this.polynom.get(j + 1).getPower()) {

                    //swap
                    Monom temp = this.polynom.get(j);
                    this.polynom.set(j,this.polynom.get(j + 1));
                    this.polynom.set(j + 1, temp);

                }
            }
        }

        combineMonom();
    }

    //combine monoms if they have equal powers
    public void combineMonom() {
        for(int i = 0; i < this.polynom.size(); i++) {
            for(int j = i + 1; j < this.polynom.size(); j++) {

                //if the monoms have equal powers
                if(this.polynom.get(i).getPower() == this.polynom.get(j).getPower()) {
                    this.polynom.get(i).setCoeff(this.polynom.get(i).getCoeff() + this.polynom.get(j).getCoeff());
                    this.polynom.remove(j);

                }
            }
        }
    }

    //to string method for polynoms
    public String toString() {
        String output = "[";
        for(int i = 0; i < this.polynom.size(); i++) {
            output += this.polynom.get(i).toString();
            if(i < this.polynom.size() - 1) output += " + ";
        }
        output += "]";
        return output;
    }

    //calculate the area between x0 to x1 by Bernhard Riemann integral
    public double area(double x0, double x1, double eps) {

        //how much rectangles
        double parts = (x1 - x0) / eps;
        double area = 0;

        for(; x0 < x1; x0 = x0 + parts) {

            //x value in the polynom
            double xValue = 0;
            for(int i = 0; i < this.polynom.size(); i++){
                xValue += this.polynom.get(i).f(x0);
            }

            //sum of rectangles area
            area += xValue * parts;
        }

        return area;
    }

    //calculate and return the derivative of the polynom
    public Polynom derivative() {

        //define new derivative polynom
        Polynom derivativePolynom = new Polynom();

        //derivative every monom in the polynom and add it to the derivative polynom
        for(int i = 0; i < this.polynom.size(); i++) {
            derivativePolynom.add(this.polynom.get(i).derivative());
        }

        //return derivative polynom
        return derivativePolynom;
    }

    //checking if the polynoms are equals
    public boolean equals(Polynom p) {

        boolean isEquals = true;

        //if size of the polynom are unequal - i can check this because the combineMonom() method
        //that combine monom if there have the same power
        if(p.getSize() != this.getSize()) {
            isEquals = false;
        } else {

            //checking if monoms are equals one by one after sortByPower and combineMonom methods
            for(int i = 0; i < this.polynom.size(); i++) {
                if(!(this.polynom.get(i).equals(p.polynom.get(i)))) isEquals = false;
            }
        }

        return isEquals;
    }

    //getting size of the polynom how much monoms in the polynom
    public int getSize() {
        return this.polynom.size();
    }

    //checking if polynom is empty or if the monom are equals to zero
    public boolean isZero() {

        boolean isZero = false;

        //if polynom is empty
        if(this.polynom.size() == 0) {
            isZero = true;

            //if monom are equals to zero
        } else {
            for(int i = 0; i < this.polynom.size(); i++) {
                if(this.polynom.get(i).isZero()) isZero = true;
            }
        }

        return isZero;
    }

    //multiply this polynom by polynom p
    public void multiply(Polynom p) {

        Polynom newPolynom = new Polynom();

        for(int i = 0; i < this.polynom.size(); i++) {
            for(int j = 0; j < p.polynom.size(); j++) {

                //create temp monom for using multiple method for monom class
                Monom temp = new Monom(0,0);

                //multiply
                Monom mul = temp.multiple(this.polynom.get(i), p.polynom.get(j));

                //adding to new polynom
                newPolynom.add(mul);
            }
        }

        //assign new polynom to this polynom
        this.polynom = newPolynom.polynom;
    }

    //searching cutting point in x axis
    public double root(double x0, double x1, double eps) {

        if(x1 < x0) {
            double temp = x0;
            x0 = x1;
            x1 = temp;
        }
        double start = x0;

        //checking if the first value of f(x0) is negative or positive
        double firstXValue = 0;
        for(int i = 0; i < this.polynom.size(); i++){
            firstXValue += this.polynom.get(i).f(x0);
        }

        boolean positive = false;
        boolean negative = false;

        if(firstXValue > 0) {
            positive = true;
        } else {
            negative = true;
        }

        //running from x0 to x1 by epsilpn
        while(x0 < x1) {

            double xValue = 0;
            for(int i = 0; i < this.polynom.size(); i++){
                xValue += this.polynom.get(i).f(x0);
            }

            //if the function is negative and turn to positive
            if(negative && xValue > 0) {
                return x0;
            }

            //if the function is positive and turn to negative
            if(positive && xValue < 0) {
                return x0;
            }

            x0 += eps;
        }

        //if there is not cutting point with x axis
        System.out.print("(root function) - there is not cutting point with X axis with the polynom: " + this.polynom + ", between " + start + " and " + x1 + ": ");
        return 0;
    }


    //substruct this polynom(a) from p polynom(b) s.t: a = a - b
    public void substruct(Polynom p) {

        //negative p monoms
        for(int i = 0; i < p.polynom.size(); i++) {
            p.polynom.get(i).setCoeff( (-1) * (p.polynom.get(i).getCoeff()));
        }

        //adding p to this
        this.add(p);

        //sorting by power
        sortByPower();
    }

    //get the polynom array list for testing
    public ArrayList<Monom> getPolynom() {
        return this.polynom;
    }

}