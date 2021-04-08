#include <iostream>
#include <string>

using namespace std;

class Complex {
    public:
        int a, b;
        void input(string s) {
            int v1 = 0, i = 0;
            while(s[i] != '+') {
                v1 = v1 * 10 + s[i] - '0';
                i++;
            }
            while(s[i] == ' ' || s[i] == '+' || s[i] == 'i') {
                i++;
            }
            int v2 = 0;
            while(i < s.length()) {
                v2 = v2 * 10 + s[i] - '0';
                i++;
            }
            this->a = v1;
            this->b = v2;
            cout << "a is: " << this->a << endl;
            cout << "b is: " << this->b << endl;
        }
        
};

// Complex::Complex operator+(const Complex& other) const {
//     Complex c;
//     c.a = this->a + other.a;
//     c.b = this->b + other.b;
//     return c;
//     // return Complex(this->a + other.a, this->b + other.b);
// }

Complex operator+(const Complex& x, const Complex& y) {
    Complex c;
    c.a = x.a + y.a;
    c.b = x.b + y.b;
    return c;
}

ostream& operator<<(ostream& stream, const Complex& other) {
    stream << other.a << "+i" << other.b;
    return stream;
}

int main() {

    Complex x, y;
    string s1, s2;
    cin >> s1;
    cin >> s2;
    x.input(s1);
    y.input(s2);
    Complex z = x + y;
    cout << z << endl;

    return 0;
}
