package lecture11;

import java.util.Arrays;

public class Rectangle {
    private double w;
    private double h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public Rectangle(Rectangle r) {
        this.w = r.w;
        this.h = r.h;
    }

    public double perimeter()  {
        return this.h*2 + this.w*2;
    }

    public double area() {
        return this.w * this.h;
    }

    public String toString() {
        return "height = " + this.h + ", width = " + this.w;
    }

    public int compare(Rectangle r) {
        double thisArea = this.h * this.w;
        double rArea = r.h * r.w;
        if(thisArea < rArea) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void sort(Rectangle[] rectArr){
        for(int i = 0; i < rectArr.length; i++){
            for(int j = i; j < rectArr.length - 1; j++){
                if(rectArr[i].h * rectArr[i].w > rectArr[j].h * rectArr[j].w) {

                    Rectangle temp = rectArr[j];
                    rectArr[i] = rectArr[j + 1];
                    rectArr[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10);

        System.out.println(r1);

        Rectangle r2 = new Rectangle(r1);

        System.out.println(r2);
        System.out.println((r2.perimeter()));
        System.out.println(r2.area());
        System.out.println(r1.compare(r2));

        Rectangle r3 = new Rectangle(10, 23);
        System.out.println(r1.compare(r3));

        Rectangle[] rectArr = {r3,r2,r1};

        Rectangle.sort(rectArr);

        System.out.println(Arrays.toString(rectArr));


    }
}
