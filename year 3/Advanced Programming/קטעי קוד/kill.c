#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void handler()
{
	printf("I Received a Signal\n");
	exit(0);
}
 
int main()
{
	signal(SIGTERM, handler);  /* Install handler */
	int counter = 1;
	while (1) {
		printf("%d: Hello\n", counter);
		++counter;
	}
}

