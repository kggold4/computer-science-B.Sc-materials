#include <iostream>
#include <string>
#include "LinkedList.hpp"

using namespace std;

namespace ariel {
    LinkedList::LinkedList() {
        this->head = nullptr;
        this->n = 0;
    }

    int LinkedList::size() {
        return this->n;
    }

    bool LinkedList::addNode(int data) {

        Node *newTail = new Node(data);

        // cannot create new node
        if(newTail == nullptr) { return false; }

        // if list is empty
        if(this->size() == 0) {
            this->head = newTail;
        }

        Node *prevTail = this->getTail();
        prevTail->next = newTail;

        this->n++;

    //    cout << "new tail is: " << to_string(this->getTail()->getData()) << endl;

        // reach maximum of node
        if(n < 0) { return false; }

        return true;
    }

    bool LinkedList::removeNode(int data) {

        // if list is empty
        if(this->size() == 0) {
            return false;

        // if list contains only one node and it's the node with the given data
        } else if(this->size() == 1 && this->getHead()->getData() == data) {
            this->head = nullptr;
            this->n--;
            return true;
        }

        Node *temp = this->getHead();

        // if the node is the head
        if(temp->getData() == data) {
            this->head = this->head->next;
            this->n--;
            return true;
        }

        // if the node is the tail
        Node *tail = this->getTail();
        if(tail->getData() == data) {
            while(temp->next != tail) {
                temp = temp->next;
            }
            temp->next = nullptr;
            this->n--;
            return true;
        }

        // if the node is some where in the middle
        while(temp->next != nullptr) {

            Node *prev = temp;
            temp = temp->next;

            // found node
            if(temp->getData() == data) {
                prev->next = temp->next;

            this->n--;
            return true;
            }
        }

        return false;
    }

    Node * LinkedList::getHead() {
        return this->head;
    }
    Node * LinkedList::getTail() {

        Node * head = this->getHead();

        if(this->n == 0 || this->n == 1) {
            return head;
        }

        while(head->next != nullptr) {
            head = head->next;
        }

        return head;
    }

    std::string LinkedList::toString() {

        // if list is empty
        if(this->size() == 0) {
            return "empty list";

        // if list only contains head
        } else if(this->size() == 1) {
            return to_string(this->getHead()->getData()) + " >> null";
        }

        std::string ans = "";
        Node * head = this->getHead();
        while(head->next != nullptr) {
            ans += to_string(head->getData()) + " >> ";
            head = head->next;
        }

        ans += to_string(this->getTail()->getData());
        ans += " >> null";
        return ans;
    }    
}
