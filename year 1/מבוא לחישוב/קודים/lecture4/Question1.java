package lecture4;

//lesson 4
//question 1
public class Question1 {
    public static void main(String[] args) {

        //variables
        int num = MyConsole.readInt("Insert length:");
        int[] randoms = new int[num];
        int count = 0;

        for(int i = 0; i < randoms.length; i++) {

            //making random numbers for 0 to num
            randoms[i] = (int)(Math.random() * num);
            System.out.println(randoms[i]);

            //zero counter
            if(randoms[i] % 10 == 0) {
                count++;
            }
        }

        System.out.println("Number of zeros: " + count);
    }
}
