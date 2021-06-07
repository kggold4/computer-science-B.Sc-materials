#include <iostream>

using namespace std;

class C {
private:
    int x, y;
public:
    C(int x, int y) : x(x), y(y) {}

    // copy constructor
    C(const C& c) {
        this->x = c.x;
        this->y = c.y;
    }
    C& operator+(const C& other) {
        this->x += other.x;
        this->y += other.y;
        return *this;
    }
    void set_to_zero() {
        this->x = 0;
        this->y = 0;
    }
    friend ostream& operator<<(ostream& out, const C& c);
};

ostream& operator<<(ostream& out, const C& c) {
    out << '(' << c.x << ")(" << c.y << ')';
    return out;
}

int main() {
    C a(5, 6);
    C b(12, 3);

    // shallow copy
    C c = a;
    C d(a);
    a = a+b;

    C* l = new C(5, 6);
    C* k = l;
    l->set_to_zero(); // change both l and k

    cout << "a: " << a << endl;
    cout << "b: " << b << endl;
    cout << "c: " << c << endl;
    cout << "d: " << d << endl;

    cout << "l: " << *l << endl;
    cout << "k: " << *k << endl;

}
