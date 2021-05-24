#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>

#define TRUE    1
#define FALSE   0


////////////////////////////////////////////////////////////////////////////
//
// List
//
//

typedef struct _NODE
{
    int val;
    struct _NODE* pNext;
} NODE;

typedef struct _LIST
{
    NODE head;
} LIST;

LIST* ListCreate()
{
    LIST* pList = (LIST*) malloc(sizeof(LIST));
    if (pList)
    {
        pList->head.pNext = NULL;
    }
    return pList;
}

void ListDestroy(LIST* pList)
{
    NODE* pNode = pList->head.pNext;

    while (pList->head.pNext)
    {
        pNode = pList->head.pNext;
        pList->head.pNext = pNode->pNext;
        free(pNode);
    }
}

void ListPushBack(LIST* pList, int val)
{
    NODE* pNode = &pList->head;

    while (pNode->pNext)
        pNode = pNode->pNext;
    pNode->pNext = (NODE*) malloc(sizeof(NODE));
    if (!pNode->pNext)
    {
        printf("Bad alloc\n");
        exit(-1);
    }
    pNode->pNext->pNext = NULL;
    pNode->pNext->val = val;
}

int ListRemoveFirst(LIST* pList)
{
    NODE* pNode = pList->head.pNext;
    int val = -1;
    
    if (pNode)
    {
        pList->head.pNext = pNode->pNext;
        val = pNode->val;
        free(pNode);
    }
    return val;
}

void ListRemove(LIST* pList, int val)
{
    NODE* pNode = &pList->head;
    NODE* pTmpNode;

    while (pNode->pNext && pNode->pNext->val != val)
        pNode = pNode->pNext;

    if (pNode->pNext)
    {
        pTmpNode = pNode->pNext;
        pNode->pNext = pTmpNode->pNext;
        free(pTmpNode);
    }
}


////////////////////////////////////////////////////////////////////////////
//
// Cache
//
//

#define BLOCK_SIZE   4096
typedef char BLOCK[BLOCK_SIZE];

void BlockCopy(BLOCK dest, BLOCK src)
{
    memcpy(dest, src, BLOCK_SIZE);
}

typedef void (*PF_WRITE)(int id, BLOCK Data);
typedef void (*PF_READ)(int id, BLOCK Data);

typedef struct _PAGE
{
    int id;
    BLOCK Data;
    char bDirty;
} PAGE;

typedef struct _CACHE
{
    PAGE* aPage;
    int size;
    int cur;
    LIST* LRU;
    PF_WRITE pfWrite;
    PF_READ pfRead;
} CACHE;


CACHE* CacheCreate(int size, PF_WRITE pfWrite, PF_READ pfRead)
{
    CACHE* pCache;
//    int i;

    pCache = (CACHE*) malloc(sizeof(CACHE));
    if (pCache)
    {
        pCache->size = size;
        pCache->cur = 0;
        pCache->pfWrite = pfWrite;
        pCache->pfRead = pfRead;

        pCache->aPage = (PAGE*) malloc(sizeof(PAGE) * size);
        if (!pCache->aPage)
        {
            free(pCache);
            return NULL;
        }

        pCache->LRU = ListCreate();
        if (!pCache->LRU)
        {
            free(pCache->aPage);
            free(pCache);
            return NULL;            
        }

//        for (i = 0; i < size; i++)
//            pCache->aPage[i].id = -1;
    }
    return pCache;
}


void CacheDestroy(CACHE* pCache)
{
    free(pCache->aPage);
    ListDestroy(pCache->LRU);
    free(pCache);
}


int EvictPage(CACHE* pCache)
{
    int index = ListRemoveFirst(pCache->LRU);

    printf("CACHE EVICT: evicting page %d\n", pCache->aPage[index].id);

    if (pCache->aPage[index].bDirty)
    {
        printf("CACHE EVICT: page %d is dirty - flushing...\n", pCache->aPage[index].id);
        pCache->pfWrite(pCache->aPage[index].id, pCache->aPage[index].Data);
    }

//    pCache->aPage[index].id = -1;
    return index;
}

void CacheWrite(CACHE* pCache, int id, BLOCK Data)
{
    int index;

    printf("*** CACHE WRITE called for page %d ***\n", id);

    // Is the page already in the cache?
    for (index = 0; index < pCache->cur; index++)
    {
        if (pCache->aPage[index].id == id)
            break;
    }

    if (index < pCache->cur)
    {
        // The page is already in the cache
        printf("CACHE WRITE: page %d is already in the cache!\n", id);
        ListRemove(pCache->LRU, index);
    }
    else if (pCache->cur < pCache->size)
    {
        // The cache is not full yet
        printf("CACHE WRITE: Cache is not full yet\n", id);
        index = (pCache->cur)++;
    }
    else
    {
        // The page is not in the cache, and the cache is full: evict a page
        printf("CACHE WRITE: Cache is full - evicting page\n", id);
        index = EvictPage(pCache);
    }

    // Insert the new page
    printf("CACHE WRITE: updating page %d in cache\n", id);
    BlockCopy(pCache->aPage[index].Data, Data);
    pCache->aPage[index].bDirty = TRUE;
    pCache->aPage[index].id = id;
    ListPushBack(pCache->LRU, index);
    printf("\n");
}

void CacheRead(CACHE* pCache, int id, BLOCK Data)
{
    int index;

    printf("*** CACHE READ called for page %d ***\n", id);

    // Is the page already in the cache?
    for (index = 0; index < pCache->cur; index++)
    {
        if (pCache->aPage[index].id == id)
            break;
    }

    if (index < pCache->cur)
    {
        // The page is already in the cache
        printf("CACHE READ: page %d is already in the cache!\n", id);
        ListRemove(pCache->LRU, index);
    }
    else
    {
        // The page is not in the cache, go get it!

        if (pCache->cur < pCache->size)
        {
            // The cache is not full yet
            printf("CACHE READ: Cache is not full yet\n", id);
            index = (pCache->cur)++;
        }
        else
        {
            // The page is not in the cache, and the cache is full: evict a page
            printf("CACHE READ: Cache is full - evicting page\n", id);
            index = EvictPage(pCache);
        }

        // Read in the page
        printf("CACHE READ: Reading in page %d\n", id);
        pCache->pfRead(id, pCache->aPage[index].Data);
        pCache->aPage[index].bDirty = FALSE;
        pCache->aPage[index].id = id;
    }

    // Return the page
    BlockCopy(Data, pCache->aPage[index].Data);
    ListPushBack(pCache->LRU, index);
    printf("\n");
}


////////////////////////////////////////////////////////////////////////////
//
// Application
//
//

void DiskWrite(int id, BLOCK Data)
{
    printf("DISK: Writing page %d\n", id);
}
void DiskRead(int id, BLOCK Data)
{
    printf("DISK: Reading page %d\n", id);
    sprintf(Data, "Block id:%d", id);
}


int main()
{
    CACHE* pCache;
    BLOCK Data;

    pCache = CacheCreate(3, DiskWrite, DiskRead);
    if (pCache)
    {
        CacheRead(pCache, 1, Data);
        CacheRead(pCache, 2, Data);
        CacheRead(pCache, 3, Data);
        CacheRead(pCache, 4, Data);
        CacheRead(pCache, 5, Data);

        CacheRead(pCache, 5, Data);
        CacheWrite(pCache, 1, Data);
        CacheRead(pCache, 2, Data);
        CacheRead(pCache, 3, Data);
        CacheRead(pCache, 4, Data);

        CacheDestroy(pCache);
    }
    return 0;
}
