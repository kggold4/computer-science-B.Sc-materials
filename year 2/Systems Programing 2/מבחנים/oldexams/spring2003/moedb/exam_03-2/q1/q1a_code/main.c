#include <stdio.h>
#include "iterator.h"
// #include "array.h"
#include "list.h"


void AlgInc(PITER pFrom, PITER pTo)
{
    int val;

    while ( !IterEq(pFrom, pTo) )
    {
        val = IterGetVal(pFrom);
        IterPutVal(pFrom, val + 1);
        printf("Changing %d\n", val);
        IterNext(pFrom);
    }
}


int main()
{
//    PARR pArr;
    PLIST pList;
    PITER pIter1, pIter2;

    // Create an array and a list
//    pArr = ArrayCreate(10);
    pList = ListCreate();

    // Put some data in the array. The second and third arguments in 'ArrayPut' are the
    // index and the values correspondingly.
/*
    ArrayPut(pArr, 0, 100);
    ArrayPut(pArr, 1, 64);
    ArrayPut(pArr, 2, -3);
    ArrayPut(pArr, 3, 46);
    ArrayPut(pArr, 4, -187);
    ArrayPut(pArr, 5, -63);
*/

    // Add some data to the list.
    ListAdd(pList, 237);
    ListAdd(pList, -73);
    ListAdd(pList, 2);
    ListAdd(pList, 0);

    // Increment array values at indices 3-5. 'ArrayAt' returns an iterator to the requested
    // index.
/*
    pIter1 = ArrayAt(pArr, 3);
    pIter2 = ArrayAt(pArr, 6);
    AlgInc(pIter1, pIter2);
    IterDestroy(pIter1);
    IterDestroy(pIter2);
*/

    // Increment all list values (except the final 0). 'ListGetFirst/Last' returns an iterator
    // to the first/last elements in the list.
    pIter1 = ListGetFirst(pList);
    pIter2 = ListGetLast(pList);
    AlgInc(pIter1, pIter2);
    IterDestroy(pIter1);
    IterDestroy(pIter2);

    // Destroy the data structures.
//    ArrayDestroy(pArr);
    ListDestroy(pList);
    return 0;
}
