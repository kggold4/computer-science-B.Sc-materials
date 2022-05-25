#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void handler()
{
	printf("Received Segmentation fault\n");
//	exit(0);
}
 
int main()
{
	signal(SIGSEGV, handler);  /* Install handler */
	int array[100];
	int index = 0;
	while (1) {
		printf("Index: %d\n", index);
		array[index] = 10;
		++index;
	}
}

