#ifndef _ARRAY_H_
#define _ARRAY_H_


#include "iterator.h"


typedef struct _Arr* PArr;


PArr ArrayCreate(unsigned int);
PIter ArrayAt(PArr, unsigned int);
void ArrayDestroy(PArr);


#endif // _ARRAY_H_
