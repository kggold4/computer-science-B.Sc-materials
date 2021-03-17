#include <iostream>
#include <string>

using namespace std;

int main() {

    string name;
    cout << "please enter your name:" << endl;

    // only grab the first word
    cin >> name;
    cout << "hello " << name << endl;
    
    /********************************/

    string fname, lname;
    cout << "please enter your full name:" << endl;

    // only grab the first two words
    cin >> fname;
    cin >> lname;
    cout << "hello " << fname << " " << lname << endl;

    return 0;
}