#include <stdio.h>
int main()
{
  char name[100];
  printf("Who are you? ");
//  gets(name);
  fgets(name, 100, stdin);
  printf("Glad to meet you: %s\n",name);
  return(0);
}
