#ifndef _LIST_H_
#define _LIST_H_


#include "iterator.h"


typedef struct _LIST* PLIST;


PLIST ListCreate();
BOOL ListAdd(PLIST, int);
BOOL ListRemove(PLIST, int);
PITER ListGetFirst(PLIST);
PITER ListGetLast(PLIST);
void ListDestroy(PLIST);


#endif // _LIST_H_
