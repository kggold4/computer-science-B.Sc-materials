package lecture3;
//lesson 3
//question 7
public class Question7 {

        public static void main(String[] args) {

            //variables
            int num = 5;

            for(int i = num; i > 0; i--) {
                String output = "";

                for(int b = 0; b < (num - i); b++) {
                    output = output + "   ";
                }

                for(int a = 0; a < i; a++) {
                    output = output + " * ";
                }

                //final output
                System.out.println(output);
            }
        }
}
