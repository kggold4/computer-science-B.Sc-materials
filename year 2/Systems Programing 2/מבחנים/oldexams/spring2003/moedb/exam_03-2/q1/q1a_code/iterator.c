#include <stdlib.h>
#include "iterator.h"


typedef struct _ITER
{
    PDS         pDS;
    PPRIV       pPriv;

    PFN_NEXT    pfnNext;
    PFN_PREV    pfnPrev;
    PFN_GETVAL  pfnGetVal;
    PFN_PUTVAL  pfnPutVal;
} ITER;


PITER IterCreate(
            PDS pDS,
            PPRIV pPriv,
            PFN_NEXT pfnNext,
            PFN_PREV pfnPrev,
            PFN_GETVAL pfnGetVal,
            PFN_PUTVAL pfnPutVal)
{
    PITER pIter;

    pIter = (PITER) malloc(sizeof(ITER));
    if (pIter)
    {
        pIter->pDS = pDS;
        pIter->pPriv = pPriv;

        pIter->pfnNext = pfnNext;
        pIter->pfnPrev = pfnPrev;
        pIter->pfnGetVal = pfnGetVal;
        pIter->pfnPutVal = pfnPutVal;
    }
    return pIter;
}

BOOL IterNext(PITER pIter)
{
    return ( NULL != (pIter->pPriv = pIter->pfnNext(pIter->pDS, pIter->pPriv)) );
}

BOOL IterPrev(PITER pIter)
{
    return ( NULL != (pIter->pPriv = pIter->pfnPrev(pIter->pDS, pIter->pPriv)) );
}

int IterGetVal(PITER pIter)
{
    return pIter->pfnGetVal(pIter->pDS, pIter->pPriv);
}

BOOL IterPutVal(PITER pIter, int val)
{
    return pIter->pfnPutVal(pIter->pDS, pIter->pPriv, val);
}

BOOL IterEq(PITER pIter1, PITER pIter2)
{
    BOOL res = (pIter1->pDS == pIter2->pDS) && (pIter1->pPriv == pIter2->pPriv);
    return res;
}

void IterDestroy(PITER pIter)
{
    free(pIter);
}
