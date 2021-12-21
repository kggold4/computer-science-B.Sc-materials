// includes
#include <iostream>
#include "LinkedList.hpp"
#include "Node.hpp"

// namespaces
using namespace std;
using namespace ariel;

int main() {

    LinkedList l1;
    l1.addNode(5);
    l1.addNode(8);
    l1.addNode(3);
    l1.addNode(4);
    l1.addNode(7);
    l1.addNode(6);
    l1.addNode(9);
    l1.addNode(1);
    cout << "list: " << l1.toString() << endl;
    cout << "size: " << l1.size() << endl;

    l1.removeNode(5);
    cout << "list: " << l1.toString() << endl;
    cout << "size: " << l1.size() << endl;

    l1.removeNode(4);
    cout << "list: " << l1.toString() << endl;
    cout << "size: " << l1.size() << endl;

    l1.removeNode(8);
    l1.removeNode(1);
    l1.removeNode(6);
    l1.removeNode(9);
    l1.removeNode(3);
    l1.removeNode(7);

    cout << "list: " << l1.toString() << endl;
    cout << "size: " << l1.size() << endl;

    return 0;
}
