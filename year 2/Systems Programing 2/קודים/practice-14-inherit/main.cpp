#include <iostream>
#include <string>

using namespace std;

class Parent {
    private:
        int p_id;
}

class Child : public Parent {
    public:
        int c_id;
}

int main() {
    Parent c = new Child;
    cout << c->c_id << endl;
}
