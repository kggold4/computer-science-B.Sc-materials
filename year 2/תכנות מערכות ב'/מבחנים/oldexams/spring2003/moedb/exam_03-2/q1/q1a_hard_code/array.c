#include <stdlib.h>
#include <string.h>
#include "array.h"


typedef struct _Arr
{
    PDATA* arr;
    unsigned int size;
} Arr;


PArr ArrayCreate(unsigned int size)
{
    PArr pArr;

    pArr = malloc(sizeof(Arr));
    if (pArr)
    {
        pArr->arr = malloc(sizeof(PDATA) * size);
        if (!pArr->arr)
        {
            free(pArr);
            return NULL;
        }
        memset(pArr->arr, 0, sizeof(PDATA) * size);
        pArr->size = size;
    }
    return pArr;
}


PDATA* ArrNext(PArr pArr, PDATA* ppData)
{
    if (ppData + 1 >= pArr->arr + pArr->size)
        return NULL;
    return ppData + 1;
}


PDATA* ArrPrev(PArr pArr, PDATA* ppData)
{
    if (!pArr || !ppData || ppData - 1 >= pArr->arr)
        return NULL;
    return ppData - 1;
}

    
PDATA ArrGetVal(PArr pArr, PDATA* ppData)
{
    if (!pArr || !ppData)
        return NULL;
    return *ppData;
}


BOOL ArrPutVal(PArr pArr, PDATA* ppData, PDATA pData)
{
    if (!pArr || !ppData)
        return FALSE;
    *ppData = pData;
    return TRUE;
}


PIter ArrayAt(PArr pArr, unsigned int i)
{
    if (!pArr || i >= pArr->size)
        return NULL;

    return IterCreate(
        pArr, 
        &pArr->arr[i],
        ArrNext,
        ArrPrev,
        ArrGetVal,
        ArrPutVal);
}


void ArrayDestroy(PArr pArr)
{
    free(pArr->arr);
    free(pArr);
}
