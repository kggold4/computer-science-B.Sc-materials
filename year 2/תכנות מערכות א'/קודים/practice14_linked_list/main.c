#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node * next;
} Node;

void deleteFirst(Node ** h) {
    if(!*h) return;
    Node *p = *h;
    *h = p -> next;
    free(p);
}

Node* newNode(int data, Node * next) {
    Node *p = (Node*)malloc(sizeof(Node));
    p -> data = data;
    p -> next = next;
    return p;
}

void addLast(Node ** head, int data) {
    Node **p = head;
    while(*p) {
        p = &((*p) -> next);
    }
    *p = newNode(data, NULL);
}



void deleteFromList(Node** h, int data) {
    if(!*h) {
        return;
    }

    Node *p = *h;
    Node **prev = h;
    while(p) {
        if(p -> data == data) {
            *prev = p -> next;
            free(p);
            p = *prev;
        } else {
            prev = &(p -> next);
            p = p -> next;
        }
    }
}

int size(Node ** head) {
    if(!*head) { return 0; }
    int count = 0;
    Node *node = *head;
    while(node != NULL) {
        node = node -> next;
        count++;
    }
    return count;
}

void printLinkedList(Node ** head) {
    if(!*head) { return; }
    Node *node = *head;
   	while (node != NULL) {
        printf("%d -> ", node -> data);
        node = node -> next;
    }
    printf("NULL\n");
}

int main() {

    Node * head;
    head = (Node*)malloc(sizeof(Node)*1);
    head -> data = 0;

    for(int i = 1; i < 10; i++) {
        addLast(&head, i);
    }
    
    printLinkedList(&head);
    deleteFromList(&head, 5);

    printf("size of linked list: %d\n", size(&head));
    
    
    return 0;
}
