#include <stdio.h>

void printDigitsBy(int n, int m) {

    // counting number of digits in n
    int count = 0, temp = n;
    while(temp != 0) {
        count++;
        temp = (int)temp / 10;
    }

    int zeros = count - m;

    if(zeros == 0) {
        printf("%d\n", n);
        return;
    }

    int base = 10;
    for(int i = 0; i < zeros - 1; i++) {
        base *= 10;
    }
    
    int result = (int)n / base;
    printf("%d\n", result);
}

int main(void) {
    printDigitsBy(987654, 3);
    return 0;
}