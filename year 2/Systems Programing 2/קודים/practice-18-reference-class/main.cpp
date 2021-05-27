#include <iostream>

using namespace std;

class Cat {
    public:
        int age;
        Cat(int new_age) {
            this->age = new_age;
        }
};

// geting c by reference
void increase_age(Cat& c) {
    c.age++;
}

int main() {
    Cat * c = new Cat(15);

    // sending to function by referece
    increase_age(*c);
    cout << c->age << endl;;
    return 0;
}
