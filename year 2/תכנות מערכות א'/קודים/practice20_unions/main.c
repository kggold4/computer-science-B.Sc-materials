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
    data.f = 220.5;

    strcpy(data.str, "C Programming");

    printf( "data.i : %d\n", data.i);
    printf( "data.i : %f\n", data.f);
    printf( "data.i : %s\n", data.str);

    // output:
    // 
    // data.i : 1917853763
    // data.i : 4122360580327794860452759994368.000000
    // data.i : C Programming
    
    return 0;
}
