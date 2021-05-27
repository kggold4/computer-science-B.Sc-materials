#include <stdio.h>
#include <string.h>

union Data {
    int i;
    float f;
    char str[20];
};

int main(void) {

    union Data data;

    data.i = 10;
    printf( "data.i : %d\n", data.i);
    // data.i : 10

    data.f = 220.5;
    printf( "data.i : %f\n", data.f);
    // data.i : 220.500000

    strcpy(data.str, "C Programming");
    printf( "data.i : %s\n", data.str);
    // data.i : C Programming
    
    return 0;
}
