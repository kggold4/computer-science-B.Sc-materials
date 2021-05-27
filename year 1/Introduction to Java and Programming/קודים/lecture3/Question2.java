package lecture3;

//lesson 3
//question 2
public class Question2 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Get number:");

        String output = "";

        //output loop
        for(int i = 0; i < num; i++) {
            output = output + " * ";
            System.out.println(output);
        }
    }
}
