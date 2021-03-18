#pragma once
#include <string>

using namespace std;

namespace ariel {
class Node {
    private:
        int data;
    
    public:
        Node *next;
        Node(int data);
        int getData();
        std::string toString();
        
};
    
}
