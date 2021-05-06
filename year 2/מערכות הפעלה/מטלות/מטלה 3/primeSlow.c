#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <math.h>

int isPrime(int num){
	int i;
	for (i = 2;i<num;i++){
		if (num%i == 0){return 0;}
	}
	return 1;
}

int main(int argc, char *argv[])
{

	if(argc != 3) {
	    printf("Too few arguments ");
	    printf("USAGE: ./primeCalc <prime pivot> <num of random numbers>");
            exit(0);
    	}

	int randomPivot = atoi(argv[1]);
	int numOfRandomNumbers = atoi(argv[2]);
	long sum = 0;
	long primeCounter = 0;
	
	//init rundom generator
    	int random = rand();
    	srand(randomPivot);

	//generate random numbers
	for (int i=0;i<numOfRandomNumbers;i++){
		random = rand();
        	//check if the number is prime
		if (isPrime(random)){
			//if do, add up it's sum, and increment counter
			sum = sum + random;
			primeCounter++;
		}	
    	}
	//keep the out format as this!!
	printf("%ld,%ld\n",sum,primeCounter);

    	exit(0);
}
