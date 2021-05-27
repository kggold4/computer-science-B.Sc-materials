#include <stdio.h>

int f1(int a) {
    return a+1;
}

int applyArray(int (*ptrFunc)(int), int arr[]) {

    int count = 0;
    for(int i = 0; i < 4; i++) {
        count += (ptrFunc)(arr[i]);
    }

    return count;
}

int main(void) {
    int arr[4] = {6,4,3,0};
    int (*ptrFunc)(int) = &f1;
    int result = applyArray(ptrFunc, arr);
    printf("%d\n", result);
    return 0;
}