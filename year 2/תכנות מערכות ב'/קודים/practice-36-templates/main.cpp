#include <iostream>
#include <string>

using namespace std;

template<typename T, int N>
class Array {
private:
    T array[N];
public:
    int getSize() { return N; };

};

int main() {
    Array<int, 5> array;
    cout << array.getSize() << endl;
    return 0;
}
