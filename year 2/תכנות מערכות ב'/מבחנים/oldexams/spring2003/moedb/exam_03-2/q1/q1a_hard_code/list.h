#ifndef _LIST_H_
#define _LIST_H_


#include "iterator.h"


typedef struct _List* PList;
typedef void* PKEY;
typedef PKEY (*PFN_GETKEY)(PDATA);
typedef int (*PFN_CMPKEY)(PKEY, PKEY);


PList ListCreate(PFN_GETKEY, PFN_CMPKEY);
BOOL ListAdd(PList, PDATA);
BOOL ListRemove(PList, PKEY);
PIter ListFind(PList, PKEY);
PIter ListGetFirst(PList);
PIter ListGetLast(PList);
void ListDestroy(PList);


#endif // _LIST_H_
