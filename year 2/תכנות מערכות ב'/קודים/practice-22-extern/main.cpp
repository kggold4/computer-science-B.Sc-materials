#include <iostream>

using namespace std;

int main() {

    // looking for var variable after compile both file:
    // use: ```g++ otherfile.cpp main.cpp```
    extern int var;
    cout << var << endl;
    return 0;
}
