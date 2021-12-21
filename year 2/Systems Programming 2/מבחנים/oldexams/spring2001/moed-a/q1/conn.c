/**********************************
*
*  FILE : conn.c
*
*  solution for MAMT exam - adtq
*
***********************************/
#include <stdlib.h>
#include "connmanage.h"
#include "conn.h"
#include "list.h"


//
// Solution for adtq part b
//
struct conn
{
	PList Q1;   // 2 queues for the bi-directional streams
	PList Q2;   // pid1 writes to Q1, pid2 writes to Q2

	int iRefCount;  // Reference count - can be 0, 1 or 2  

	int pid1;       // The 2 peers pids 
	int pid2;

	cpy_fun cpy;    // The copy element function (used when reading an element)
};


//
// Solution for adtq part d
//

void ConnClose(PConn pc)
{
	if (--(ph->pconn->iRefCount) == 0)
	{
		RemoveConn(ph->pconn->pid1, ph->pconn->pid2);
		
		ListDestroy(pc->Q1);
		ListDestroy(pc->Q2);

		free(pc);
	}
}


BOOL ConnWrite(PConn pc, PElem* pe)
{
	PElem pNew;
	if (1 == pc->iRefCount)
		return FALSE;

	pNew = ph->pconn->cpy(pe);
	
	if (getpid() == pc->pid2)
		return ListAddLast(ph->pconn->Q2, pNew);
	else
		return ListAddLast(ph->pconn->Q1, pNew);
}

//
// Solution for adtq part c (in code -
// the students should describe it in words)
//

static Conn* ConnAlloc(cpy_fun cpy, int iToPid)
{
	PConn pConn = malloc(sizeof(Conn));
	pConn->Q1 = ListCreate();
	pConn->Q2 = ListCreate();
	pConn->cpy = cpy;
	pConn->iRefCount = 0;
	pConn->pid1 = getpid();
	pConn->pid2 = iToPid;

	return pConn;
}
	

HANDLE* ConnCreate(int pid, cpy_fun cpy)
{
	PConn pConn = FindConn(getpid(), pid);
	if (NULL == pConn)
	{
		// A new conn needs to be allocated
		pConn = ConnAlloc(cpy,pid);
		AddConn(getpid(), pid, pConn);
	}
		
	if (pConn->iRefCount >= 2)
		return NULL;
	
	pConn->iRefCount++;

	return pConn;
}





//
// Just for the general perspective:
//
	
PElem ConnRead(PConn pc)
{
	if (getpid() == pc->pid2)
		return ListGetFirst(ph->pconn->Q1);
	else
		return ListGetFirst(ph->pconn->Q2);
}


