#include <iostream>

using namespace std;

int main() {

    // const pointer to un-const variable
    int i = 10, j = 15, k = 20;

    int * const p1 = &i;

    p1++;    // compile error
    (*p1)++; // ok

    // un-const pointer to const variable
    const int * p2 = &j;

    p2++;    // ok
    (*p2)++; // compile error

    // const pointer to a const variavle
    const int * const p3 = &k;

    return 0;
}
