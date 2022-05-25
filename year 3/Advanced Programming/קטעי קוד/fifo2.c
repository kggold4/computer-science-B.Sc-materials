#include <unistd.h>
#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
int main()
{
	char buf[128];
	int fd = open("named_pipe", O_RDONLY);
	read(fd, buf, 128);
	printf ("%s\n", buf);
	close (fd);
}
