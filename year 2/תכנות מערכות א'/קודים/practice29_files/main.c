#include <stdio.h>

int main(void) {

    FILE * file_to_write = fopen("testfile.txt", "w");
    char c = 97;
    while(c < 123) {
        putc(c, file_to_write);
        c++;
    }

    fclose(file_to_write);

    return 0;
}
