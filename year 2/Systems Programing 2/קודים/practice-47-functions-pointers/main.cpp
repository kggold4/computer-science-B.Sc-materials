#include <iostream>
#include <vector>

using namespace std;

void print(int value) {
    cout << "value(regular): " << value << endl;
}

// getting a function as an argument
void forEach(const vector<int>& values, void(*function)(int)) {
    for(int value : values) {
        function(value);
    }
}

int main() {

    vector<int> values = { 1, 5, 4, 2, 3 };

    // sending a regular funciton
    forEach(values, print);

    // sending lambda function
    forEach(values, [](int value) { cout << "value(lambda): " << value << endl; });
    

    return 0;
}
