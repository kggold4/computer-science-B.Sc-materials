#include <stdio.h>

int main(void) {

    FILE * fp = fopen("myfile.bin", "ab+");
    // file format: n "asknfasfnasf"

    int size;

    // read 4 first bit as an int (size)
    fread(&size, sizeof(int), 1, fp);

    // seek from the end (go backward)
    fseek(fp, -sizeof(char), SEEK_END);

    // seek backward size times
    for(int i = 0; i < size; i++) {

        // create new char
        char ch;

        // read char from file
        fread(&ch, sizeof(ch), 1, fp);

        // write char to file
        fwrite(&ch, sizeof(char), 1, fp);

        // seek backward
        fseek(fp, -2*(i+1)*sizeof(char)-1, SEEK_END);
    }
    fclose(fp);

    return 0;
}
