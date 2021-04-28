#include <iostream>

using namespace std;

class Pos {

    public:
        double x, y;
        double getX() const {
            return x;
        }

        double getY() const {
            return y;
        }
};

class Player : public Pos {
    private:
        string name;

    public:
        Player(string name) {
            name = name;
            x = y = 0;
        }

        string getName() const {
            return name;
        }
};

int main() {

    Player a("kfir");
    cout << "name: " << a.getName() << endl;

    return 0;
}
