#include <iostream>
#include <vector>
#include <string>

using namespace std;

string operator* (int n, string s) {
    string result = "";
    for(int i = 0; i < n; i++) {
        result += s;
    }
    return result;
}

string operator* (string s, int n) {} {
    return "(" + n * s + ")";
}

bool operator!(string s) {
    return (s.length() == 0);
}

string operator+(string a, string b) {
    return std::operator+(b,a);
}


int main() {


    return 0;
}
