package assignment2;

public class M_2 {
    //main function
    public static void main(String[] args) {

        int n = binary2int(int2Binary(30));
        System.out.println(n);

    }

    //part 1
    //prime factors function
    public static int[] primeFactors(int n) {

        int[] primes;

        //if n is less than 2
        if(n < 2) {
            System.out.println("invaled input, you need to insert a number grater or equal to 2.");
            int[] empty = {0};
            return empty;

            //if n is grater or equal to 2
        } else {
            //k is for counting how many primes have in n, the counter is len (length)
            //prime is for checking if k/n is % prime == 0, if not prime++
            int k = n, prime = 2, len = 0;

            //counting primes numbers for the array
            while(k != 1) {
                if(k % prime == 0) {
                    len++;
                    k = k / prime;
                } else {
                    prime++;
                }
            }

            //initialize prime for the for loop
            prime = 2;

            //define the array with the length
            primes = new int[len];

            //insert primes to the array
            for(int i = 0; i < primes.length; i++) {
                if(n % prime == 0) {
                    primes[i] = prime;
                    n = n / prime;
                } else {
                    prime++;
                    i--;
                }
            }
        }

        //return the array to main function
        return primes;
    }

    //part 2
    //checking if k is a hamming number
    public static boolean isHammingNumber(int k) {

        boolean isHamming = false;

        //getting from hammingNumbers function a array of hamming numbers by length of k
        //and cheking in for loop if k is equal to hamming number in the array
        int[] checkingHamming = hammingNumbers(k);

        for(int i = 0; i < checkingHamming.length; i++) {
            if(k == checkingHamming[i]) {
                isHamming = true;
                break;
            }
        }

        if(k < 1) isHamming = false;

        //return if k is a hamming number
        return isHamming;
    }

    //generate hamming numbers array with length of n
    public static int[] hammingNumbers(int n) {

        if(n < 1) {
            System.out.println("invaled number, you need to insert a number that grater or equal to 1.");
            int[] empty = {0};
            return empty;
        } else {
            int hammings[] = new int[n];
            int i, i2, i3, i5, x, x2, x3, x5;

            hammings[0] = 1; i = 0; x = 1;

            i2 = i3 = i5 = -1;
            x2 = 2; x3 = 3;
            x5 = 5;

            while (++i < n) {
                hammings[i] = x = (x2 <= x3 && x2 <= x5) ? x2 : (x3 <= x5) ? x3 : x5;
                while (x2 <= x) x2 = 2 * hammings[++i2];
                while (x3 <= x) x3 = 3 * hammings[++i3];
                while (x5 <= x) x5 = 5 * hammings[++i5];
            }

            return hammings;
        }
    }

    //part 3
    //converting binary array to a number
    public static int binary2int(int[] b ) {

        int num = 0;

        //if the array is valid
        if(isBinaryArray(b)) {

            int len = b.length - 1;
            for(int i = 0; i < b.length; i++) {
                num += b[i] * Math.pow(2, len);
                len--;
            }

            //if the array is invalid
        } else {
            System.out.println("invaled binary number");
            num = 0;
        }

        return num;

    }

    //converting number to a binary array
    public static int[] int2Binary (int n) {

        //if n is less the 0 and invalid
        if(n < 0) {
            System.out.println("invalid number, you need to insert a number that grater or equal to 0.");
            int[] binaryArray = {0};
            return binaryArray;

            //if n is grater or equal 0 and valid
        } else {
            int k = n;

            int len = 0;
            while(n != 0) {
                if(n % 2 == 0) {
                    n = n / 2;
                    len++;
                } else if(n % 2 == 1) {
                    n = n - 1;
                    n = n / 2;
                    len++;
                }
            }

            int[] binaryArray = new int[len];

            int index = 0;
            while(k != 0) {
                if(k % 2 == 0) {
                    k = k / 2;
                    binaryArray[index] = 0;
                    index++;
                } else if(k % 2 == 1) {
                    k = k - 1;
                    k = k / 2;
                    binaryArray[index] = 1;
                    index++;
                }
            }

            for(int i = 0; i < binaryArray.length / 2; i++) {
                int t = binaryArray[i];
                binaryArray[i] = binaryArray[binaryArray.length - i - 1];
                binaryArray[binaryArray.length - i - 1] = t;
            }

            return binaryArray;
        }
    }

    //checking if the binary array is valid
    public static boolean isBinaryArray(int[] b) {

        boolean isBinary = true;

        for(int i = 0; i < b.length; i++) {
            if((b[i] != 0) && (b[i] != 1)) {
                isBinary = false;
            }
        }

        return isBinary;
    }
}
