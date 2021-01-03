package assignment1;

public class Ex1_2 {
    //Quadratic equation calculator
    public static void main(String[] args) {

        //Variables
        double exit = 1, a, b, c ,discriminant, result, x1, x2;

        while(exit == 1) {

            //if start or exit the program
            exit = MyConsole.readDouble("Enter a number: 0) exit,  1) aX^2+bX+c=0");
            if(exit == 1) {

                //Input equation variables
                System.out.println("aX^2+bX+c=0: enter a, b, c");
                a = MyConsole.readDouble("Enter a: ");
                b = MyConsole.readDouble("Enter b: ");
                c = MyConsole.readDouble("Enter c: ");

                //if a = 0 and b != 0
                if(a == 0 && b != 0) {

                    result = -c;
                    result = result / b;
                    System.out.println(a + "X^2+" + b + "X+" + c + "=0");
                    System.out.println("X1 = X2 = " + result + "\n");

                    //if a = 0 and b = 0 and c != 0
                } else if(a == 0 && b == 0 && c != 0) {

                    System.out.println(a + "X^2+" + b + "X+" + c + "=0");
                    System.out.println("Error, no answer!\n");

                    //if a = 0 and b = 0 and c = 0
                } else if (a == 0 && b == 0 && c == 0) {

                    System.out.println(a + "X^2+" + b + "X+" + c + "=0");
                    System.out.println("x1 can be any number - trivial!\n");

                    //if a != 0
                } else {

                    System.out.println(a + "X^2+" + b + "X+" + c + "=0");
                    discriminant = Math.pow(b,2) - 4 * a * c;

                    // if b^2 - 4 * a * c > 0
                    if(discriminant > 0) {

                        x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                        x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                        System.out.println("x1 = " + x1 + "\tx2 = " + x2 + "\n");

                        // if b^2 - 4 * a * c = 0
                    } else if(discriminant == 0) {

                        result = -b;
                        result = result / (2 * a);
                        System.out.println("X1 = X2 = " + result + "\n");

                        // if b^2 - 4 * a * c < 0
                    } else {

                        System.out.println("Error: NO real roots!\n");

                    }

                }

                //exit the program exit != 1
            } else {
                break;
            }
        }

        System.out.println("Ex1 - done!");
    }
}
