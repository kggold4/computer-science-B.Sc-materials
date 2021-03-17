#include <stdlib.h>
#include <stdio.h>

int main() {

    char * val;
    val = getenv("MyEnv");
    if(val == NULL) {
        printf("Env. variable not found\n");
    } else {
        printf("Env. variable contains %s\n", val);
    }

    return 0;
}