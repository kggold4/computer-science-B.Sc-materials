#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
int main()
{
   char buffer[1024];
   int in, out, nread, nwrite;
   in = open("input_file", O_RDONLY);
   if (in == -1) {
       perror("open input file: ");
       exit(1);
   }
   out = open("output_file", O_WRONLY);
//2   out = open("out", O_WRONLY | O_TRUNC);
//3   out = open("out", O_WRONLY | O_APPEND);
//4   out = open("out", O_WRONLY | O_CREAT, S_IRUSR | S_IWUSR);
//5   out = open("out", O_WRONLY | O_CREAT | O_EXCL, S_IRUSR | S_IWUSR);
   if (out == -1) {
       perror("open output file: ");
       exit(1);
   }
   while((nread = read(in,buffer,1024)) > 0)
      write(out,buffer,nread);	
   exit(0);
}


