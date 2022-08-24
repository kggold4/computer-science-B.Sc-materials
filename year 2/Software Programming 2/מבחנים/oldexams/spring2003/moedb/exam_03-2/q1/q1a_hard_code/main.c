#include <stdio.h>
#include "array.h"
#include "algorithm.h"


void PrintInt(int* p)
{
    printf("%d\n", *p);
}


int main()
{
    PArr pArr;
    PIter pIter, pIter2;
    int data[] = { 1, 2, 3, 4, 5 };
    
    pArr = ArrayCreate(10);
    if (pArr)
    {
        pIter = ArrayAt(pArr, 0);
        pIter2 = ArrayAt(pArr, 0);

        IterPutVal(pIter2, &data[0]);
        IterNext(pIter2);
        IterPutVal(pIter2, &data[1]);
        IterNext(pIter2);
        IterPutVal(pIter2, &data[2]);
        IterNext(pIter2);

        AlgForeach(pIter, pIter2, PrintInt);

        IterDestroy(pIter);
        IterDestroy(pIter2);
        ArrayDestroy(pArr);
    }
    return 0;
}
