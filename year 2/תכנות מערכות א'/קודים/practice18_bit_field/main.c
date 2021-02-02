#include <stdio.h>

typedef struct status {
    unsigned int age: 7; // max is 127
} status;


int main(void) {

    // calculate max number:
    // 1 1 1 1 1 1 1
    // 2^0 + 2^1 + 2^2 + 2^3 + 2^4 + 2^5 + 2^6 = 128

    struct status x;
    x.age = 127;
    printf("%d\n",x.age);    
    
    return 0;
}
