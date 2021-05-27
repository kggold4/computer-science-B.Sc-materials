#include <stdio.h>
#include <stdlib.h>
//#include <conio.h>

/* Node Stucture */
typedef struct Node {
    int data;
    struct Node *next;
} Node;

/* Add a new node to linked list */
Node * add(int num, Node *head) {
    Node *node;
    node = (Node *) malloc(sizeof(Node));
    node -> data = num;
    node -> next= head;
    head = node;
    return head;
}

// void duplicateData(int data, Node *head) {
//     while(*h)
//     if( (*h) -> data == data) {
//     *h = newNode(data,*h);
//     h = &( (*h)->next->next);
//     } else
//     h = &((*h)->next);
// } 

/* Print all the elements in the linked list */
void print(Node *head) {
    Node *node = head;
   	while(node != NULL) {
        printf("%d ", node -> data);
        node = node -> next;
    }
}

/* Count the number of nodes in a linked list */
int count(Node *head) {
    int n = 0;
    Node *node = head;
    while(node != NULL) {
        n++;
        node = node -> next;
    }
    return(n);
}

/* Remove an element from a linked list */
Node * removeNode(int num, Node *head) {
    Node *node = head;
    Node *prev_node;
    while( node != NULL) {
        if(node -> data == num) {
            if(node == head) {
                 head = node -> next;
            } else {
                prev_node -> next = node -> next;
            }
        } 
        prev_node = node;
        node = node -> next;
    }
    return(head);
}

/* Program main */ 
int main()
{

    Node *head = NULL;
    int num;
    int option;
    // char * temp;

    /* Display Menu */
    while(1) {

        printf("\n ******************************************\n");
        printf("\n *  Linked list operations:               *\n");
        printf("\n *    1. Add                              *\n");
        printf("\n *    2. Remove                           *\n");
        printf("\n *    3. Count                            *\n");
        printf("\n *    4. Print                            *\n");    
        printf("\n *    5. Quit                             *\n");    
        printf("\n ******************************************\n");
        printf("\n Choose an option [1-5] : ");
        if (scanf("%d", &option) != 1) {
            printf(" *Error: Invalid input. Press try again.\n");
            scanf(" "); /*this will clear the input buffer */
            continue;
        }

        switch (option) {
            case 1:        /* Add */
                printf(" Enter a number to add : ");
                if (scanf("%d", &num) != 1) {
                    printf(" *Error: Invalid input. Only integer numbers are allowed\n");
                    scanf(" ");    /*this will clear the input buffer */
                    continue;
                }
                head = add(num, head);
                printf("Number %d is now added to the list", num);
                printf("\nPress any key to continue...");
                //getch();
                break;

            case 2:    /* Remove */
                printf(" Enter a number to remove : ");
                if (scanf("%d", &num) != 1) {
                    printf(" *Error: Invalid input. Only integer numbers are allowed\n");
                    scanf(" ");    /*this will clear the input buffer */
                    continue;
                }
                head = removeNode(num, head);
                printf("Number %d is now removed from the list", num);
                printf("\nPress any key to continue...");
                // getch();
                break;

            case 3:    /* Count */
                printf("\nYour linked list contains %d nodes", count(head));
                printf("\nPress any key to continue...");
                // getch();
                break;

            case 4: /* Print */
                printf("\nYour linked list contains the following values: \n [ ");
                print(head);
                printf("]\n\nPress any key to continue...");
                // getch();
                break;

            case 5:    /* Exit */
                return(0);
                break;

            default:
                printf("Invalid Option. Please Try again.");
                // getch();

            } /* End of Switch */
    } /* End of While */

return(0);
}
