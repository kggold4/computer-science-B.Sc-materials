#include <stdio.h>
int main(void) {
    FILE *fp;
    char ch, st[4]; 

    // read file called "testfile.txt", use pointer fp
    if (!(fp = fopen("testfile.txt", "r"))) {
        return 1;
    }

    // print file
    while(fscanf(fp, "%c", &ch) != EOF) {
	    printf("%c", ch);
    }

    // return in the pointer to the start of the file
    rewind(fp);
    
    while(fgets(st, 4, fp) != NULL) {
        printf("%s", st); fclose(fp);

        // rename file from "testfile.txt" to "testfile2.txt"
        rename("testfile.txt", "testfile2.txt");

        // remove file "testfile2.txt"
        remove("testfile2.txt");
    }
}