#ifndef _ITER_H_
#define _ITER_H_


// Common definitions
typedef enum { FALSE, TRUE } BOOL;
typedef void* PDATA;

// Iterator types
typedef struct _Iterator* PIter;
typedef void* PDS;
typedef void* PPRIV;

typedef PPRIV (*PFN_NEXT)(PDS, PPRIV);
typedef PPRIV (*PFN_PREV)(PDS, PPRIV);

typedef PDATA (*PFN_GETVAL)(PDS, PPRIV);
typedef BOOL (*PFN_PUTVAL)(PDS, PPRIV, PDATA);


// Interface
PIter IterCreate(PDS, PPRIV, PFN_NEXT, PFN_PREV, PFN_GETVAL, PFN_PUTVAL);
BOOL IterNext(PIter);
BOOL IterPrev(PIter);
PDATA IterGetVal(PIter);
BOOL IterPutVal(PIter, PDATA);
BOOL IterEq(PIter, PIter);
void IterDestroy(PIter);


#endif // _ITER_H_
