#include <stdio.h>

int main(void) {

    FILE * stream;

    if((stream = fopen("test1.dat", "r")) == NULL) {
        printf("unable to open file\n");
        return 1;
    }

    // read data using file

    if(fclose(stream) == EOF) {
        printf("error closing file\n");
        return 2;
    }

    return 0;
}
