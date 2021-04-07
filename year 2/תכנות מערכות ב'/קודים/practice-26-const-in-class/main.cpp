#include <iostream>

using namespace std;

class Item {
    private:
        int id;
        double price;
    public:
        Item(int id, double price) {
            this->id = id;
            this->price = price;
        }
        ~Item() {}
        int getId() {
            return this->id;
        }
        double getPrice() {
            return this->price;
        }
        void show() const {
            // this->id = 15; // read only - error
            cout << "id is: " << this->id << endl;
            cout << "price is: " << this->price << endl;
        }
};

int main() {

    Item * a = new Item(51, 3.5);
    cout << "id is: " << a->getId() << endl;
    cout << "price is: " << a->getPrice() << endl;
    a->show();

    return 0;
}
