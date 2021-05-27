#include <iostream>
#include <string>

using namespace std;

template<int N>
class Array {
private:
    int m_Array[N];
public:
    int getSize() const { return N; }

};

int main() {
    Array<10> array;
    cout << array.getSize() << endl;

    

    return 0;
}
