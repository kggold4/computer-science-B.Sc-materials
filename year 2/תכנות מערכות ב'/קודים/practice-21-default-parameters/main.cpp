#include <iostream>

using namespace std;

void func(int n = 5) {
    cout << "number is: " << n << endl;
}

int main() {

    func();
    func(20);
    func();

    return 0;
}
