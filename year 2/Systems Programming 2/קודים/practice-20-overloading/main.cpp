#include <iostream>

using namespace std;

void func() {
    cout << "function with no arguments" << endl;
}

void func(int x) {
    cout << "function with argument: " << x + 1 << endl;
}

int main() {
    
    // working properly
    func();
    func(15);

    return 0;
}
