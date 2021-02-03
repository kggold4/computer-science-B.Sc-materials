#include <stdio.h>
#include <stdlib.h>
struct threeNum {
    int n1, n2, n3;
};

int  main() {

    // new struct
    struct threeNum num;

    // pointer to the file
    FILE *fptr;

    // open file
    if((fptr = fopen("program.bin","rb")) == NULL) {
        printf("error! opening file");
        return 1;
    }

    // seek from the end
    fseek(fptr, -sizeof(struct threeNum), SEEK_END);


    for(int n = 1; n < 5; n++) {

        // read to num three numbers
        fread(&num, sizeof(struct threeNum), 1, fptr);

        // print numbers
        printf("n1: %d\tn2: %d\tn3: %d\n", num.n1, num.n2, num.n3);

        // seek from current mark index
        fseek(fptr, -2*sizeof(struct threeNum), SEEK_CUR);
    }

    // close file
    fclose(fptr);
}
