#include <iostream>
#include <set>

using namespace std;

void printSet(const set<int> numbers) {
    cout << "set:" << endl;
    set<int>::iterator it = numbers.begin();
    int index = 0;
    while(it != numbers.end()) {
        cout << index << ": " << *it << endl;
        index++;
        it++;
    }
}

int main() {

    set<int> numbers;

    numbers.insert(15);
    numbers.insert(13);
    numbers.insert(12);
    numbers.insert(13);
    numbers.insert(12);
    numbers.insert(103);
    numbers.insert(2);
    numbers.insert(7);

    printSet(numbers);

    numbers.erase(15);
    
    printSet(numbers);

    numbers.clear();

    cout << "clear!" << endl;
    printSet(numbers);
    
    
    return 0;
}
