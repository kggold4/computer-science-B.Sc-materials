#ifndef _ALG_H_
#define _ALG_H_


#include "iterator.h"


typedef void (*PFN_MODIFY)(PDATA);
BOOL AlgForeach(PIter pFrom, PIter pTo, PFN_MODIFY pfnModify);


#endif // _ALG_H_
