#include <iostream>
#include <climits>
#include <float.h>
using namespace std;

void print_size_of(int bytes, string data_type) {
    cout << "size of " << data_type << ": " << bytes << " bytes and " << bytes * 8 << " bits" << endl;
}

enum week { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday };

int main() {

    print_size_of(sizeof(bool), "bool");
    print_size_of(sizeof(char), "char");
    print_size_of(sizeof(short), "short");
    print_size_of(sizeof(int), "int");
    print_size_of(sizeof(long), "long");
    print_size_of(sizeof(float), "float");
    print_size_of(sizeof(double), "double");
    print_size_of(sizeof(long double), "long double");

    cout << endl;

    cout << "max of char: " <<  CHAR_MAX << endl;
    cout << "max of unsigned char: " <<  UCHAR_MAX << endl;

    cout << "max of short: " <<  SHRT_MAX << endl;
    cout << "max of unsigned short: " <<  USHRT_MAX << endl;

    cout << "max of int: " <<  INT_MAX << endl;
    cout << "max of unsigned int: " <<  UINT_MAX << endl;

    cout << "max of long: " <<  LONG_MAX << endl;
    cout << "max of unsigned long: " <<  ULONG_MAX << endl;

    cout << endl;

    double x = 7.7E4; // 7.7 * 10^4
    cout << "x is: " << x << endl;
    cout << "x is: " << fixed << x << endl;

    // number of digits after point in a float
    cout << FLT_DIG << endl;

    // number of digits after point in a double
    cout << DBL_DIG << endl;

    // number of digits after point in a long float
    cout << LDBL_DIG << endl;

    // constant variables
    const int z = 10;

    week today;
    today = Wednesday;
    cout << "Day " << today+1;
    return 0;

}