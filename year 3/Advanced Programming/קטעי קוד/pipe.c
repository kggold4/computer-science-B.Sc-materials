#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <errno.h>
#include <stdio.h>
#define MAXLINE 1024
int main(void)
{
	int n;
	int fd[2];
	pid_t pid;
	char line[MAXLINE];
	if (pipe(fd) < 0) {
		printf("pipe error = %d\n", errno);
       		perror("open");
       		exit(1);
   	}
	if ((pid = fork()) < 0) {
		printf("fork error = %d\n", errno);
       		perror("open");
       		exit(1);
	} else if (pid > 0) { /* parent */
		close(fd[0]);
		write(fd[1], "hello world\n", 12);
	} else { /* child */
		close(fd[1]);
		n = read(fd[0], line, MAXLINE);
		write(1, line, n);
	}
	exit(0);
}
