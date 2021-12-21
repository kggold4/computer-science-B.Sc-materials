#include "Node.hpp"
#include <string>

using namespace std;

namespace ariel {
    Node::Node(int data) {
        this->data = data;
        this->next = nullptr;
    }

    int Node::getData() {
        return this->data;
    }

    std::string Node::toString() {
        return to_string(this->data);
    }
}
