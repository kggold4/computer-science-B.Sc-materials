#include <stdio.h>
#include <stdlib.h>

int main() {
    
    int n;
    char *text;

    printf("\nenter limit of the text: ");
    scanf("%d", &n);

    text = (char*)malloc(n * sizeof(char));

    printf("\nenter text: ");
    scanf("%s", text);
    // scanf(" ");
    // gets(text);

    printf("interupted text is: %s\n", text);

    free(text);
    
    return 0;
}
