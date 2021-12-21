#include <stdio.h>
#include <stdlib.h>

int main() {

    int x = 1;

    // save x value in binary file
    FILE * file_to_write = fopen("program.bin", "wb");
    while(x < 13) {
        fwrite(&x, sizeof(int), 1 , file_to_write);
        x++;
    }
    
    if(file_to_write == NULL) {
        printf("errror write to file");
        return 1;
    }

    fclose(file_to_write);

    // read saved file
    FILE *file_to_read;
    if((file_to_read = fopen("program.bin","rb")) == NULL) {
        printf("error! read file");
        return 1;
    }

    // get x value to y (15)
    int y;
    fread(&y, sizeof(int), 1, file_to_read);
    printf("num is: %d\n", y);

    fclose(file_to_read);
}
