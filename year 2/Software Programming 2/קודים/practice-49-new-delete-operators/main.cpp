#include <iostream>
#include <string>

using namespace std;

class car {
    string name;
    int num;

public:
    car(string s, int n) {
        cout << "Constructor" << endl;
        this->name = s;
        this->num = n;
    }

    void display() {
        cout << "name: " << this->name << endl;
        cout << "num: " << this->num << endl;
    }

    void * operator new(size_t size) {
        cout << "new operator overloaded" << endl;
        void * p = malloc(size);
        return p;
    }

    void operator delete(void * ptr) {
        cout << "delete operator overloaded" << endl;
        free(ptr);
    }

};

int main() {

    car *p = new car("HYUNDAI", 2012);
    p->display();
    delete p;

    return 0;
}
