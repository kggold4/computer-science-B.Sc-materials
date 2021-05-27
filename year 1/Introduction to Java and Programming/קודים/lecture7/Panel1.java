package lecture7;

import java.util.Arrays;

//lesson 7
//panel 1
public class Panel1 {
    public static void main(String[] args) {

        String s = "abcbcdabbx";

        int[] freq = getNumOfChars(s);

        System.out.println(Arrays.toString(freq));

    }

    public static int[] getNumOfChars(String s) {

        int size = 'z' - 'a' + 1;
        int[] freq = new int[size];

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }

        return freq;
    }
}
