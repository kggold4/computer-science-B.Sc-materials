#include <stdio.h>
#include <string.h>

int main() {
    char string[] = {'a','b','c','d','e','\0'};
    puts(string);
    printf("%ld\n", strlen(string));

    char string2[] = "abcde";
    puts(string2);
    printf("%ld\n", strlen(string2));
    return 0;
}
