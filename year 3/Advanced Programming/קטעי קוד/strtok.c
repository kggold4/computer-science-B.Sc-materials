#include <string.h>
#include <stdio.h>

int main () {
   char str[80] = "       aa bbb       ccc     ddd  1234\n";
   const char s[2] = " ";
   char *token;
   
   /* get the first token */
   token = strtok(str, s);
   /* walk through other tokens */
   while( token != NULL ) {
      printf( "%s\n", token);    
      token = strtok(NULL, s);
   }
}
