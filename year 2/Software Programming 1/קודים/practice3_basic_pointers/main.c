#include <stdio.h>
void f(int *z) {
    int *a, b;
    z++;
    a = &z[0];
    b = z[2];
    (*a)--;
    ++b;
}

int main() {
    int arr[5] = {10,20,30,40,50}, i;
    f(arr);
    for(i = 0; i < 5; i++)
    printf("%d ", arr[i]);
    printf("\n");
}