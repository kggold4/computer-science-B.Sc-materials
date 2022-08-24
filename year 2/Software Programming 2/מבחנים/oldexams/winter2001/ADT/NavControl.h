// ANSWERS TO NavControl ADT Question

// Part A:
#ifndef _NAVCONTROL_
#define _NAVCONTROL_

typedef struct tagNavControl NavControl, NC;
typedef char* URL;

Result NCInit    (NC ** ppNC, URL url);
void   NCDestroy (NC* pNC);

Result NCNewUrl  (NC* pNC, URL url);
Result NCBack    (NC* pNC);
Result NCForward (NC* pNC);

URL    NCCurrent (NC* pNC);


#endif

//Part B I:
/*
** I'm using the top of the lstBack as current url
**
*/

struct tagNavControl
{
	Stack *pstkBack,
		  *pstkForward;

};




// Part C:

Result NCBack    (NC* pNC)
{
	URL url;
	
	if (StackCount(&(pNC->stkBack)) == 1)
		// reached top of stack - no more back
		return FAIL;

	url = StackTop(&(pNC->stkBack));
	StackPop(&(pNC->stkBack));

	return StackPush(&(pNC->stkForward), url);
}




// Part D:  Nothing - All the stack interface used 
//          by NavControl remained unchanged.


