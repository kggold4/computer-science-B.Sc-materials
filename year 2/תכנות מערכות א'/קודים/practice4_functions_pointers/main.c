#include <stdio.h>

int f(int x) {
    return x*2+1;
}

void print(char * string) {
    printf("%s\n", string);
}

int main() {

    // pointer to f
    int (*ptr_f)(int) = &f;
    printf("%d\n", (*ptr_f)(2021));

    // pinter to print
    void (*ptr_p)(char*) = &print;
    char string[] = "hello my name is ____, and this is a pointer to a function";
    (*ptr_p)(string);

    return 0;
}