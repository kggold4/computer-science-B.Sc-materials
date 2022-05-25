#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void handler()
{
	printf("Received SIGINT (ctrl-C)\n");
}
 
int main()
{
	signal(SIGINT, handler);  /* Install handler */
//	signal(SIGTERM, handler);  /* Install handler */
	while (1) ; /* Wait for SIGINT */
}

