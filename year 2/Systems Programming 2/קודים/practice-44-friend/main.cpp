#include <iostream>
#include <string>

using namespace std;

class P {
private:
    string name;
    int age;
public:
    P(string name, int age)
        : name(name), age(age) {};
    friend void print(const P& p);
    friend ostream& operator<<(ostream& out, const P& p);
};

void print(const P& p) {
    cout << "name: " << p.name << ", age: " << p.age << endl;
}

ostream& operator<<(ostream& out, const P& p) {
    out << "name: " << p.name << ", age: " << p.age << endl;
    return out;
}

int main() {
    P p("kfir", 24);
    print(p);
    
    cout << p;
    return 0;
}
