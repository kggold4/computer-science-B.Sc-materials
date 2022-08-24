#include <stdio.h>
#include <stdlib.h>

union Data {
    int i;
    float f;
    char str[20];
};


int main(void) {

    union Data data;

    printf("memory size occupied by data: %ld\n", sizeof(data));
    
    return 0;
}
