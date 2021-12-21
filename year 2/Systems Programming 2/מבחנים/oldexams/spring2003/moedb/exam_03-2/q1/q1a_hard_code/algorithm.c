#include "algorithm.h"


BOOL AlgForeach(PIter pFrom, PIter pTo, PFN_MODIFY pfnModify)
{
    while ( !IterEq(pFrom, pTo) )
    {
        pfnModify(IterGetVal(pFrom));
        if (!IterNext(pFrom))
            return FALSE;
    }
    return TRUE;
}


BOOL AlgCopy(PIter pSrcStart, PIter pSrcEnd, PIter pDest)
{
    while ( !IterEq(pSrcStart, pSrcEnd) )
    {
        if ( !IterPutVal(pDest, IterGetVal(pSrcStart)) )
            return FALSE;

        if (!IterNext(pSrcStart) || !IterNext(pDest))
            return FALSE;
    }
    return TRUE;
}


/*
typedef int (*COMP)(PDATA, PDATA);
BOOL AlgorithmMerge(PIter pSrc1, PIter pSrc2, PIter pDest, COMP pComp)
{
    ITerFirst(pSrc1);
    ITerFirst(pSrc2);
    ITerFirst(pDest);

    while (IterValid(pSrc1) || IterValid(pSrc2))
    {
        if (!IterValid(pDest)
        {
            return FALSE;
        }

        if (IterValid(pSrc1) && IterValid(pSrc2))
        {
            if (pComp(IterGetVal(pSrc1), IterGetVal(pSrc2)) > 0)
            {
                IterPut(pDest, IterGetVal(pSrc1));
                IterNext(pSrc1);
            }
            else
            {
                IterPut(pDest, IterGetVal(pSrc2));
                IterGetNext(pSrc2);
            }
        }
        else if (IterValid(pSrc1))
        {
            IterPut(pDest, IterGetVal(pSrc1));
            IterGetNext(pSrc1);
        }
        else
        {
            IterPut(pDest, IterGetVal(pSrc2));
            IterGetNext(pSrc2);
        }
        IterGetNext(pDest);
    }
    return TRUE;
}
*/
