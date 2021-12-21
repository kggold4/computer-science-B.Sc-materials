#include <stdio.h>
#include <stdlib.h>

int main() {
    
    int * arr;
    int limit, i, sum = 0;

    printf("enter total number of elements:");
    scanf("%d", &limit);

    arr = (int*)malloc(sizeof(int) * limit);

    if(arr == NULL) {
        return 1;
    }

    printf("enter %d elements:\n", limit);
    for(i = 0; i < limit; i++) {
        printf("enter element %d: ", i+1);
        scanf("%d", (arr + i));
        sum = sum + *(arr + i);
    }

    printf("array elements are: \n[");
    for(i = 0; i < limit; i++) {
        if(i != limit -1) {
            printf("%d, ", *(arr + i));
        } else {
            printf("%d", *(arr + i));
        }
        
    }

    printf("]\nsum of all elements is: %d\n", sum);


    free(arr);

    return 0;
}
