#include <stdio.h>
#include <stdlib.h>

int main() {

    int *i;
    char *c;
    float *f;

    i = (int*)malloc(sizeof(int) * 1);
    c = (char*)malloc(sizeof(char) * 1);
    f = (float*)malloc(sizeof(float) * 1);

    printf("\nenter integer: ");
    scanf(" %d", i);

    printf("\nenter char: ");
    scanf(" %c", c);

    printf("\nenter float: ");
    scanf(" %f", f);

    printf("integer: %d, char: %c, float: %f\n", *i, *c, *f);


    free(i);
    free(c);
    free(f);
    
    return 0;
}
