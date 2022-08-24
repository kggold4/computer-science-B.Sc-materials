#include <iostream>
#include <string>

using namespace std;

int main() {

    cout << "enter text here:" << endl;

    string text;

    // grab the all text
    getline(cin, text);
    cout << "the text is: " << text << endl;

    return 0;
}
