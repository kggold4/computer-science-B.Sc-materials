#include <stdio.h>

double f(unsigned int num) {
    return num + 0.5;
}

double g(unsigned int num) {
    return num - 0.5;
}

unsigned int intersect_point(unsigned int range) {
    for(int num = 0; num <= range; num++) {
        if(f(num) == g(num)) {
            return num;
        }
    }
    return range + 1;
}


int main() {
    printf("%d", intersect_point(0));
    return 0;
}
