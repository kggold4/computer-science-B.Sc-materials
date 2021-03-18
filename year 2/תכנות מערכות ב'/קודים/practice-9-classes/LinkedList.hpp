#pragma once
#include <string>
#include "Node.hpp"

using namespace std;

namespace ariel {
    class LinkedList {
    private:
        Node *head;
        unsigned int n;

    public:
        // default construtor
        LinkedList();
        int size();
        bool addNode(int data);
        bool removeNode(int data);
        Node * getHead();
        Node * getTail();
        std::string toString();

};

}
