#include <stdio.h>
#include <stdlib.h>

int main(void) {

    FILE *file_to_read = fopen("sometext.txt", "r");
    FILE *file_to_write = fopen("newtext.txt", "w");

    if(file_to_read == NULL || file_to_write == NULL) {
        return 1;
    }

    char c;
    while((c = fgetc(file_to_read)) != EOF) {
        if(c == '.') {
            c = '!';
        }
        putc(c, file_to_write);
    }

    fclose(file_to_read);
    fclose(file_to_write);

    return 0;
}
