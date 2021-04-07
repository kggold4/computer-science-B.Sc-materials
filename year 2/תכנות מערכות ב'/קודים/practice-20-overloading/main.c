#include <stdio.h>

/**
 *
 * Error:
 * Multiple defination of func
 * 
 * */

void func() {
    printf("function with no arguments\n");
}

void func(int x) {
    printf("arguments: %d\n", x + 1);
}

int main() {
    func();
    func(15);
    return 0;
}
