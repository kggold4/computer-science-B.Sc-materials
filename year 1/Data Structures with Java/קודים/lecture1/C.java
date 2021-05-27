package lecture1;

public class C {

    public static void main(String[] args) {
        int towerHeigth = 20;
        char fromPole = 'A';
        char withPole = 'B';
        char toPole = 'C';

        hanoi(towerHeigth, fromPole, toPole, withPole);

        System.out.println("moves: " + moves);
    }

    static int moves = 0;

    public static void hanoi(int height, char fromPole, char toPole, char withPole) {
        if(height >= 1) {
            hanoi(height - 1, fromPole, withPole, toPole);
            moves++;
            hanoi(height - 1, withPole, toPole, fromPole);
        }
    }
}