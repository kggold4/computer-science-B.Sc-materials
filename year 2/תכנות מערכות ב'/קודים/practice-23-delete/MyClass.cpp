#include <iostream>
#include "MyClass.hpp"

using namespace std;

const int SIZE = 1000;

MyClass::MyClass() {
    _mem = new char[SIZE];
    cout << "construct MyClass" << endl;
}

MyClass::~MyClass() {
    delete[] _mem;
    cout << "destruct MyClass" << endl;
}
