#include <iostream>
using namespace std;

double my_pow(int x, int n) {
    int result = 1, i = 0;
    while(i < n) {
        result = result * x;
        i++;
    }
    return result;
}

int main() {

    int base, exponent;

    cout << "enter base: ";
    cin >> base;

    cout << "enter exponent: ";
    cin >> exponent;

    double x = my_pow(base, exponent);
    cout << base << "^" << exponent << " is: " << x << endl;

    return 0;
}