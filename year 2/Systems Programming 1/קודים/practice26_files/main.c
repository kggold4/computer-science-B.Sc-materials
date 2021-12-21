#include <stdio.h>

int main(void) {

    // removing a file called "file_to_delete.txt"
    int a = remove("file_to_delete.txt");
    if(a == -1) {
        return 1;
    }

    // rename a file called "file_to_rename.txt" to "file_to_rename(renamed).txt"
    int b = rename("file_to_rename.txt", "file_to_rename(renamed).txt");
    if(b == -1) {
        return 2;
    }

    return 0;
}