#ifndef _ITER_H_
#define _ITER_H_


// Common definitions
typedef enum { FALSE, TRUE } BOOL;

// Iterator types
typedef struct _ITER* PITER;
typedef void* PDS;
typedef void* PPRIV;

typedef PPRIV (*PFN_NEXT)(PDS, PPRIV);
typedef PPRIV (*PFN_PREV)(PDS, PPRIV);

typedef int (*PFN_GETVAL)(PDS, PPRIV);
typedef BOOL (*PFN_PUTVAL)(PDS, PPRIV, int);


// Interface
PITER IterCreate(PDS, PPRIV, PFN_NEXT, PFN_PREV, PFN_GETVAL, PFN_PUTVAL);
BOOL IterNext(PITER);
BOOL IterPrev(PITER);
int IterGetVal(PITER);
BOOL IterPutVal(PITER, int);
BOOL IterEq(PITER, PITER);
void IterDestroy(PITER);


#endif // _ITER_H_
