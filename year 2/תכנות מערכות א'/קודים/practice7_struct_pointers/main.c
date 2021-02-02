#include <stdio.h>
#define MAX 256


typedef struct Node {
    char name[MAX];
    int x, y;
} Node;

int main() {

    Node n0 = {
        .x=1,
        .y=2,
        .name="nodename0"
    };
    printf("%s\n", n0.name);

    Node *node_ptr = &n0;

    printf("%s\n", (*node_ptr).name);
    printf("%s\n", node_ptr -> name);

    printf("%d\n", node_ptr -> x);
    node_ptr -> x = 12;
    printf("%d\n", node_ptr -> x);
    
    return 0;
}
