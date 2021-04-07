#include <iostream>

using namespace std;

void swap(int &a,int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {

    int i = 10;
    int &j = i; // & - reference

    j += 5; // change both - now i = j = 15

    cout << "i is: " << i << ", j is: " << j << endl;

    int x = 31;
    int y = 9;
    swap(x, y);

    cout << "x is: " << x << ", y is: " << y << endl;

    return 0;
}

 /**
  * 
  * there is three ways to pass arguments:
  * by pointer
  * by reference
  * by value
  * int * func(int *ptr, int &ref, int val);
  * 
  * */