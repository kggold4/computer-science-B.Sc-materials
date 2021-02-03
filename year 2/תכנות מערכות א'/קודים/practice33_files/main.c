#include <stdio.h>

int compare_files(char * file1, char * file2) {

    FILE * file1_open = fopen(file1, "r");
    FILE * file2_open = fopen(file2, "r");

    if(file1_open == NULL || file2_open == NULL) {
        return -1;
    }

    char c1;
    char c2;
    while(c1 != EOF && c2 != EOF) {
        c1 = fgetc(file1_open);
        c2 = fgetc(file2_open);
        if(c1 != c2) {
            return -1;
        }
    }

    if(c1 != EOF || c2 != EOF) {
        return -1;
    }

    fclose(file1_open);
    fclose(file2_open);

    return 2;
}

int main(void) {
    
    int ans = compare_files("f1.txt","f2.txt");
    printf("%d\n", ans);

    return 0;
}
