#include <stdlib.h>
#include "list.h"


typedef struct _NODE
{
    int val;
    struct _NODE* pNext;
    struct _NODE* pPrev;
} NODE, *PNODE;

typedef struct _LIST
{
    PNODE pFirst;
    PNODE pLast;
} LIST;


PLIST ListCreate()
{
    PLIST p = (PLIST) malloc(sizeof(LIST));
    if (p)
    {
        p->pFirst = p->pLast = NULL;
    }
    return p;
}


BOOL ListAdd(PLIST pList, int val)
{
    PNODE pn = (PNODE) malloc(sizeof(NODE));
    if (!pn)
        return FALSE;

    pn->val = val;
    pn->pNext = NULL;
    pn->pPrev = pList->pLast;
    if (pList->pLast)
    {
        pList->pLast->pNext = pn;
    }
    else
    {
        pList->pFirst = pn;
    }
    pList->pLast = pn;
    return TRUE;
}


BOOL ListRemove(PLIST pList, int val) { return TRUE; }


PNODE ListNext(PLIST pList, PNODE pNode)
{
    if (!pList || !pNode || !pNode->pNext)
        return NULL;
    return pNode->pNext;
}


PNODE ListPrev(PLIST pList, PNODE pNode)
{
    if (!pList || !pNode || !pNode->pPrev)
        return NULL;
    return pNode->pPrev;
}


int ListGetVal(PLIST pList, PNODE pNode)
{
    if (!pList || !pNode)
        return 0;
    return pNode->val;
}


BOOL ListPutVal(PLIST pList, PNODE pNode, int val)
{
    if (!pList || !pNode)
        return FALSE;
    pNode->val = val;
    return TRUE;
}


PITER ListGetFirst(PLIST pList)
{
    if (!pList->pFirst)
        return NULL;
    return IterCreate(pList, pList->pFirst, ListNext, ListPrev, ListGetVal, ListPutVal);
}


PITER ListGetLast(PLIST pList)
{
    if (!pList->pLast)
        return NULL;
    return IterCreate(pList, pList->pLast, ListNext, ListPrev, ListGetVal, ListPutVal);
}


void ListDestroy(PLIST pList)
{
    PNODE pNode;

    while (pList->pFirst)
    {
        pNode = pList->pFirst;
        pList->pFirst = pNode->pNext;
        free(pNode);
    }
}
