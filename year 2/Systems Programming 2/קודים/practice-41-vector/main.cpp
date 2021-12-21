#include <iostream>
#include <vector>

using namespace std;

int main() {

    size_t a, b;
    cin >> a >> b;

    vector<unsigned char> pixels(a*b, 0);

    vector<unsigned char>::iterator it = pixels.begin();
    while(it != pixels.end()) {
        cout << *it; // *it is contains nothing...
        it++;
    }

    return 0;
}
