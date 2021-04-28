#include <iostream>

using namespace std;

int& val() {
    static int value = 10;
    value++;
    return value;
}

// can get only lvalues
void setValue1(int& a) {
    ++a;
    cout << "setValue1: " << a << endl;
}

// can get also rvalues because it's const
void setValue2(const int& a) {
    //++a; error
    cout << "setValue2: " << a << endl;
}

// can get only rvalues
void setValue3(const int&& a) {
    cout << "setValue3: " << a << endl;
}

void string1(string& str) {
    cout << "string1: " << str << endl;
}

void string2(const string& str) {
    cout << "string2: " << str << endl;
}

int main() {

    // using val function
    int i = val();
    val() = 15;
    int j = val();
    cout << "first value is: " << i << endl;
    cout << "second value is: " << j << endl;

    // using setValue1 function
    int temp = 3;
    setValue1(temp);
    // setValue1(10); // error because 10 is not a lvalue

    // using setValue2 function
    setValue2(9);

    // using setValue3 function
    setValue3(10); // rvalue
    // setValue3(temp); // error because lvalue
    int x = 6, y = 19;
    setValue3(x + y); // rvalue

    // **
    string fname = "Kfir";
    string lname = "Goldfarb";

    // using string1 function
    string1(fname); // working because the argument is lvalue
    // string1(fname + lname); // error because the argument string is rvalue

    // using string2 function
    string2(lname); // lvalue
    string2(fname + lname); // rvalue

    return 0;
}
