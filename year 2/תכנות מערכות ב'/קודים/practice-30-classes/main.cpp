#include <iostream>

using namespace std;

class Box {
    private:
        int l, b, h;
    public:
        // default constructor
        Box() {
            this->l = this-> b = this->h = 0;
        }

        // constructor
        Box(int length, int breadth, int height) {
            this->l = length;
            this->b = breadth;
            this->h = height;
        }

        // copy constructor
        Box(const Box& B) {
            this->l = B.l;
            this->b = B.b;
            this->h = B.h;
        }

        int getLength() {
            return this->l;
        }

        int getBreadth() {
            return this->b;
        }

        int getHeight() {
            return this->h;
        }

        long long CalculateVolume() {
            return this->l * this->b * this->h;
        }

        bool operator<(const Box& other) const {
            if(this->l < other.l) {
                return true;
            } else if(this->b < other.b && this->l == other.l) {
                return true;
            } else if(this->h < other.h && this->b == other.b && this->l == other.l) {
                return true;
            }
            return false;
        }
};

ostream& operator<<(ostream& out, Box& B) {
    int l = B.getLength();
    int b = B.getBreadth();
    int h = B.getHeight();
    out << l << ' ' << b << ' ' << h;
    return out;
}

int main() {

    Box b1;
    Box b2(2, 3, 4);
    cout << b2.getLength() << endl;;
    cout << b2.getBreadth() << endl;;
    cout << b2.getHeight() << endl;;
    cout << b2.CalculateVolume() << endl;;
    bool x = (b1 < b2);
    cout << x << endl;
    bool y = (b2 < b1);
    cout << y << endl;
    cout << b2 << endl;

    Box b3(b2);

    cout << b3 << endl;

    return 0;
}
