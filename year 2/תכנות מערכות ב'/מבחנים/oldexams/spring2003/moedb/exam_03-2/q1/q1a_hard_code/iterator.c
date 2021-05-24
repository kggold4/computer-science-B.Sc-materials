#include <stdlib.h>
#include "iterator.h"


typedef struct _Iterator
{
    PDS         pDS;
    PPRIV       pPriv;

    PFN_NEXT    pfnNext;
    PFN_PREV    pfnPrev;
    PFN_GETVAL  pfnGetVal;
    PFN_PUTVAL  pfnPutVal;
} Iterator;


PIter IterCreate(
            PDS pDS,
            PPRIV pPriv,
            PFN_NEXT pfnNext,
            PFN_PREV pfnPrev,
            PFN_GETVAL pfnGetVal,
            PFN_PUTVAL pfnPutVal)
{
    PIter pIter;

    pIter = (PIter) malloc(sizeof(Iterator));
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

BOOL IterNext(PIter pIter)
{
    return ( NULL != (pIter->pPriv = pIter->pfnNext(pIter->pDS, pIter->pPriv)) );
}

BOOL IterPrev(PIter pIter)
{
    return ( NULL != (pIter->pPriv = pIter->pfnPrev(pIter->pDS, pIter->pPriv)) );
}

PDATA IterGetVal(PIter pIter)
{
    return pIter->pfnGetVal(pIter->pDS, pIter->pPriv);
}

BOOL IterPutVal(PIter pIter, PDATA pData)
{
    return pIter->pfnPutVal(pIter->pDS, pIter->pPriv, pData);
}

BOOL IterEq(PIter pIter1, PIter pIter2)
{
    BOOL res = (pIter1->pDS == pIter2->pDS) && (pIter1->pPriv == pIter2->pPriv);
    return res;
}

void IterDestroy(PIter pIter)
{
    free(pIter);
}
