#include <stdio.h>

void intPointer(int *ip) {
   *ip = *ip * 10;
}

void arrayPointer(int ips[]) {
   for(int i = 0; i < 4; ++i) {
      ips[i] = ips[i] * 50;
   }
}

int main () {

   int num = 110;
   int *ip;

   ip = &num;
   intPointer(ip);
   printf("%d\n", num);

   int array[] = {1,3,5,6};
   arrayPointer(array);
   for(int i = 0; i < 4; ++i) {
      printf("%d, ", array[i]);
   }

   return 0;
}