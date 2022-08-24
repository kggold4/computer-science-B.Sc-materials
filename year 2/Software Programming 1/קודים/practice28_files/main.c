#include <stdio.h>

int main(void) {

    FILE * file_to_read = fopen("testfile.txt", "r");
    FILE * file_to_write = fopen("testfile2.txt", "w");

    if(file_to_read == NULL) {
        return 1;
    }
    
    char c;
    while((c = getc(file_to_read)) != EOF) {
        if(c == '.') {
            c = '\n';
            putc('.', file_to_write);
        }
        putc(c, file_to_write);
    }

    fclose(file_to_read);
    fclose(file_to_write);

    return 0;
}