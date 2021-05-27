 #include <unistd.h>
 #include <stdio.h>

int main()
 {

  int pid, x[2];
  char instring[20];

  pipe(x); //initialise pipe

  pid = fork();
  if (pid == 0)           /* child : sends message to parent*/
  {
   /* write 7 character to the write end of pipe */
   write(x[1], "Hi Mom!", 7); 
  }
  else   /* parent : receives message from child */
  {
   /* read from the pipe */
   read(x[0], instring, 7);
   printf("%s",instring);
  }
}
