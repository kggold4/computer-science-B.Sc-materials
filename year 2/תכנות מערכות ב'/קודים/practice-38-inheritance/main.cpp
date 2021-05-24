#include <iostream>
#include <string>

using namespace std;

class Parent {
    private:
        int x, y;
        bool some_boolean_array[5];
        string private_string() { return "private str"; }
    protected:
        double protected_array[5];
        string protected_string() { return "protected str"; }
    public:

        // default constructor
        Parent() { this->x = this->y = 0; }

        // constructor
        Parent(int x, int y) {
            this->x = x;
            this->y = y;
        }
        // copy constructor
        Parent(Parent& other) {
            this->x = other.x;
            this->y = other.y;
        }

        

        int getX() const { return this->x; }
        int getY() const { return this->y; }

        string public_string() { return "public str"; }

        friend ostream& operator<<(ostream& out, const Parent& parent);
};

ostream& operator<<(ostream& out, const Parent& parent) {
    out << parent.getX() << " : " << parent.getY();
    return out;
}

class A : public Parent {
    public:
        A(int x, int y) : Parent(x, y) {
            cout << this->public_string() << endl;
            //cout << this->protected_string();
            //cout << this->private_string();
        }
};
class B : protected Parent {
    public:
        B(int x, int y) : Parent(x, y) {
            cout << this->public_string() << endl;
            cout << this->protected_string();
            //cout << this->private_string();
        }
};
class C : private Parent {
    public:
        C(int x, int y) : Parent(x, y) {
            cout << this->public_string() << endl;
            cout << this->protected_string();
            //cout << this->private_string();
        }
};

int main() {
    A a(2, 3);
    B b(5, 6);
    C c(9 ,8);
    return 0;
}
