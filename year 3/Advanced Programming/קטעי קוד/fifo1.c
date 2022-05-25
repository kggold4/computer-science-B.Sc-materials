#include <unistd.h>
#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
int main()
{
	char *line = "tesing named pipe";
	int fd;
	mkfifo("named_pipe", S_IRUSR | S_IWUSR); // create a named pipe
	fd = open("named_pipe", O_WRONLY); // open named pipe for write
	write (fd, line, strlen(line)); // write to pipe
	close (fd);
}
