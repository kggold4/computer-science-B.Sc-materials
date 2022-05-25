#include<stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void handler()
{
	return; // nothing to do, just return to wake up the pause
}
 
int main()
{
	signal(SIGALRM, handler);  // install handler
	alarm(5);   // receive SIGALRM in 5s
	pause() ;   // wait for SIGALRM
	printf("continue after 5s ...\n");
}

