#include <iostream>
#include <string>

using namespace std;
int main() {

    string text1 = "this is a text sample";
    string text2 = "this is another text sample";
    string text3 = text1 + " and " + text2;
    cout << text3 + "!" << endl;

    cout << text1[0] << endl;
    cout << text2[15] << endl;

    cout << text3.length() << endl;

    return 0;
}