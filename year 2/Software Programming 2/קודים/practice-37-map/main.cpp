#include <iostream>
#include <map>

using namespace std;

void printMap(const map<int, double> amounts) {
    cout << "map:" << endl;
    for(auto &v: amounts) {
        cout << "id: " << v.first << ", amount: " << v.second << endl;
    }
}

int main() {

    map<int, double> amounts;

    amounts.insert(pair<int, double>(5, 13.453));
    amounts.insert(pair<int, double>(10, 3.783));
    amounts.insert(pair<int, double>(1, 6.378));
    amounts.insert(pair<int, double>(6, 4.456));
    amounts.insert(pair<int, double>(4, 2.453));
    

    printMap(amounts);

    amounts.erase(5);

    printMap(amounts);
    



    return 0;
}
