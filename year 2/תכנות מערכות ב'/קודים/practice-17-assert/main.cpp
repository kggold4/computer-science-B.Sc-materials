#include <iostream>
#include <cassert>

using namespace std;

int main() {

    int x = 0;
    assert(x == 0);
    assert(x < 5);
    assert(x > 5); // bug

    return 0;
}
