#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char * name = (char*)malloc(13 * sizeof(char));
    if(name == NULL) {
        return 1;
    }
    strcpy(name, "engineer man");
    puts(name);

    //

    int * numbers = (int*)calloc(2, sizeof(int));
    if(numbers == NULL) {
        return 1;
    }
    numbers[0] = 1;
    numbers[1] = 2;

    //

    name = realloc(name, 25 * sizeof(char));
    if(name == NULL) {
        return 1;
    }
    strcat(name, " is the best");
    puts(name);

    free(name);
    free(numbers);
    
    return 0;
}
