#include <stdio.h>
#include <stdlib.h>

int main() {
    

    int n;
    scanf("%d", &n);
    
    // malloc array
    int *arr = (int*)malloc(sizeof(int) * n);
    if(arr == NULL) {
        return 1;
    }

    for(int i = 0; i < n; ++i) {
        scanf("%d", &arr[i]);
    }

    for(int i = 0; i < n; ++i) {
        printf("%d ", arr[i]);
    }

    // free memorey of the array
    free(arr);

    return 0;
}
