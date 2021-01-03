package assignment1;

public class Ex1_1 {
    //Celcius and farenheit convertor
    public static void main(String[] args) {

        //Farenheit to celcius
        double far = MyConsole.readDouble("Enter temprature farenheit:");
        double farToCel = far;
        farToCel = farToCel - 32;
        farToCel = farToCel * 5;
        farToCel = farToCel / 9;
        System.out.println(farToCel + " C = " + far + " F \n");

        //Celcius to farenheit
        double cel = MyConsole.readDouble("Enter temprature celcius:");
        double CelToFar = cel;
        CelToFar = CelToFar * 9;
        CelToFar = CelToFar / 5;
        CelToFar = CelToFar + 32;
        System.out.println(CelToFar + " F = " + cel + " C");

    }
}
