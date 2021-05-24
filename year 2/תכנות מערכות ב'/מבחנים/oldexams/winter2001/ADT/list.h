/**********************************************************************	
*	MAMAT WINTER 2001 EX1 - list.h
*
*   List ADT interface
*
************************************************************************/
#ifndef LIST_H
#define LIST_H

typedef void* PData;
typedef void* PKey;
typedef enum result {FAIL, SUCCESS} Result;

// Compare function
typedef int (*CompFunction)(PKey, PKey);

// Key function
typedef PKey (*KeyFunction)(PData);


struct tagList;
typedef struct tagList List, *PList;


/*
**	Initializes the list.
*/

Result ListCreate(PList* pList, KeyFunction key_function, CompFunction comp_function); 

/*
**	Adds the data element 'data' to the list.
*/

Result ListInsert(PList plist, PData pdata);

/*
**   Removes the data element with the matching key from the list.
*/

PData ListRemove(PList plist, PKey pkey);

/*
**   Returns the data element with the matching key, 
**   or NULL, if such element isn't found 
*/

PData ListFind(PList plist, PKey pkey);

/*
**   Returns the number of elements in the list   
*/

int ListCount(PList plist);


/*
**  Frees memory allocated for the list
*/

void ListDestroy(PList plist);

/*
**   To scan all elements in the list:
**  First use ListIteratorReset(), then ListGetNext() to get the elements
*/
void ListResetIterator(PList plist);

/*
**  Returns (a pointer to) the element, or NULL if 
**  end of the list was reached.
*/
PData ListGetNext(PList plist);

#endif
