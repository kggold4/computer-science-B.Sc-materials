#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <errno.h>
#include <stdio.h>
int main()
{
   char block[1024];
   int in, out;
   int nread;
   in = open("file.in", O_RDONLY);
   if (in == -1) {
       printf("errno = %d\n", errno);
       perror("The error is: ");
       exit(1);
   }
   out = open("file.out", O_WRONLY|O_CREAT, S_IRUSR|S_IWUSR);
//   out = open("file.out", O_WRONLY);
   if (out == -1) {
       perror("open");
       exit(1);
   }
   while((nread = read(in,block,sizeof(block))) > 0)
      write(out,block,nread);
   exit(0);
}
