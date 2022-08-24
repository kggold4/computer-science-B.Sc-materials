#ifndef _STACK_H_
#define _STACK_H_

typedef struct tagStack Stack;
typedef void *PData;

typedef enum result {FAIL,  SUCCESS} Result;
typedef enum _bool  {FALSE, TRUE}    BOOL;

/*
** The stack does NOT free any of the user's 
** memory (the PData's). The user should
** free all PDatas before StackDestroy() 
*/

Result StackCreate       (Stack ** ppStack);
void   StackDestroy      (Stack *   pStack);

// Pushes the new data to the stack
Result StackPush         (Stack* pStack, PData data);

// Pops the top data element. Does nothing if stack is empty.
void   StackPop          (Stack* pStack);

// Returns a ptr to the top data element of the stack
PData  StackTop          (Stack* pStack);

// Is The stack empty ?
BOOL   StackIsEmpty      (Stack* pStack);

// Returns the number of elements in the stack
int    StackCount        (Stack* pStack);


#endif