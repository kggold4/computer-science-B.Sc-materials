#include <iostream>
#include <string>

using namespace std;

void func(int x) {
    if(x < 0) {
        throw string("string error: " + to_string(x));
    }
}

int main() {

    try {
        func(-1);
    } catch(string message) {
        cout << "caught exception: " << message << endl;
    }

    return 0;
}
