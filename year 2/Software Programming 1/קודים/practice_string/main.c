#include <stdio.h>
#include <string.h>

int main() {

    char string1[] = "hello world\0";
    char string2[50] = "this is a parctice of string\0";
    char string3[20] = "hello world\0"; // = string1
    char text1[] = {'h','e','l','l','o','\0'};
    char text2[6] = "hello\0";

    printf("len: %ld, text: %s\n", sizeof(string1), string1);
    printf("len: %ld, text: %s\n", sizeof(string2), string2);
    printf("len: %ld, text: %s\n", sizeof(string3), string3);
    printf("len: %ld, text: %s\n", sizeof(text1), text1);
    printf("len: %ld, text: %s\n", sizeof(text2), text2);

    printf("\n\n\n");

    char a[] = "a";
    char b[] = "b";

    printf("a,b: %d\n", strcmp(a,b)); // -1
    printf("b,a: %d\n", strcmp(b,a)); // 1
    printf("a,a: %d\n", strcmp(a,a)); // 0
    printf("text1,text2: %d\n", strcmp(text1,text2));

    printf("\n\n\n");

    char space[] = " ";
    strcat(string1, space);
    strcat(string1, string2);
    puts(string1);

    puts("enter a string: ");
    char text3[50];
    fgets(text3, 50, stdin); 
    puts(text3);


    printf("\n\n\n");


    memcpy(string1, text3, 15);
    printf("%s\n", string1);
    printf("%s\n", string2);


    return 0;
}