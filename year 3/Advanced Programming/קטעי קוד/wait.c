#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int main()
{
   int pid;
   int status;
   pid = fork();

   if (pid == 0) {
      printf("%s\n","---------------- child ----------------");
//     execl("/bin/date","date", NULL);
//      execlp("ls", "ls", NULL);
      execlp("ls", "ls", "-y", "a.out",  NULL);
   }

   else if (pid > 0) {
      wait(&status);
//	wait(0);
      printf("%s\n","---------------- parent ----------------");
      printf("%s%d\n","exit status of child is: ", status >> 8);
      return 0;
   }
}

