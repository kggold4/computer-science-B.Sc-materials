#include <iostream>
#include <stdexcept>

using namespace std;

void func(int x) {
    if(x < 0) {
        throw std::out_of_range("x should be at least 0");
    }
}

int main() {

    try {
        func(-1);
    } catch(const std::exception& ex) {
        cout << "caught exception: " << ex.what() << endl;
    }

    return 0;
}
