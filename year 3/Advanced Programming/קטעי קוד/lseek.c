#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
char	buf1[] = "AAAAAAAAAAAAAAAAAAAA";
char	buf2[] = "BBBBB";
int main(void) {
	int	fd, pos;
	fd = open("out.txt", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
	write(fd, buf1, 20);
	lseek(fd, 50, SEEK_END);
	write(fd, buf2, 5);
}
