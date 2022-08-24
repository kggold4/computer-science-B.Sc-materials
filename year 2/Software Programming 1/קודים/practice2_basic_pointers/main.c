#include <stdio.h>

int main() {
    char *arr[] = {"Programmin", "using", "C language", "is fun!"};
    char *p = arr[3]; // p = {"is fun!"}
    char *q = *(arr + 1);
    *(q + 2) = '\0';
    // q = {"using", "C language", "\0"}

    printf("%s", arr[2]); // "C language"
    printf("%s", arr[2] + 2); // "error"
    printf("%s", q); // "error", q is array
    printf("%c", arr[2][0]); // 'C'
    printf("%s", p + 3); // 'f'
    return 0;
}