#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Items {

    private:
        class Item {
            private:
                long id;
            public:
                Item(long id) {
                    this->id = id;
                }
                long getID() {
                    return this->id;
                }
                string toString() {
                    return to_string(this->id);
                }
        };
        vector<Item> items;

    public:
        void addItem(long id) {
            Item * item = new Item(id);
            this->items.push_back(item);
        }

        void print() {
            vector<Item>::iterator iter;
            for(iter = this->items.begin(); iter != this->items.end(); ++iter) {
                cout << &iter << " : ";
            }
            cout << endl;
        }
};

int main() {
    Items * items;
    items->addItem(5);
    items->addItem(8);
    items->addItem(3);
    items->print();
    return 0;
}
