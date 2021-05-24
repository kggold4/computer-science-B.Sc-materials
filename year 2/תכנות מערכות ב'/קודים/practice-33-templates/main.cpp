#include <iostream>
#include <string>

using namespace std;

template<typename T> void print(T value) {
    cout << value << endl;
}

int main() {

    print(5);
    print("string for print");
    print(3.12f);
    print(1.2123645);
    
    return 0;
}
