#include <iostream>
#include <string>

using namespace std;

class Person {
    private:
        int age;
        string name;
    public:
        Person(const string &name, int age) : name(name), age(age) {}
        Person(const string &name) : name(name), age(-1) {}
        Person(int age) : age(age), name("unknown") {}

        int get_age() const { return this->age; }
        string get_name() const { return this->name; }
};

int main() {
    Person a("john");
    Person b("kfir", 24);
    cout << a.get_age() << endl;
    cout << a.get_name() << endl;
    cout << b.get_age() << endl;
    cout << b.get_name() << endl;

    Person c = string("strange");
    cout << c.get_age() << endl;
    cout << c.get_name() << endl;

    Person d = 25;
    cout << d.get_age() << endl;
    cout << d.get_name() << endl;
    return 0;
}
