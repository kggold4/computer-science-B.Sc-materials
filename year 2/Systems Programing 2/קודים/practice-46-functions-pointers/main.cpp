#include <iostream>

using namespace std;

void print1() {
    cout << "hello world!" << endl;
}

void print2(int num) {
    cout << "hello world! " << num << endl;
}

int main() {

    /**
     * 
     * USING print1 FUNCTION
     * 
     * */

    // way 1 to do it
    typedef void(*helloworldfunction1)();  // declare a typedef of an void function pointer
    helloworldfunction1 function1 = print1; // create function 1 as an void funciton pointer
    function1();

    // way 2 to do it
    void(*function2)() = print1;
    function2();

    // way 3 to do it
    auto function3 = &print1;
    function3();

    /**
     * 
     * USING print2 FUNCTION
     * 
     * */

    // way 1 to do it
    typedef void(*helloworldfunction2)(int);  // declare a typedef of an void function pointer
    helloworldfunction2 function4 = print2; // create function 1 as an void funciton pointer
    function4(4);

    // way 2 to do it
    void(*function5)(int) = print2;
    function5(5);

    // way 3 to do it
    auto function6 = &print2;
    function6(6);

    return 0;
}
