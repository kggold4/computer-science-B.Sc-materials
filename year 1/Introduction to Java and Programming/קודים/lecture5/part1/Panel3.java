package lecture5.part1;

//lesson 5
//panel 3
public class Panel3 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 50; i++) {
            if(i % 2 == 0) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("count = " + count);
        System.out.println(end - start);

    }
}
