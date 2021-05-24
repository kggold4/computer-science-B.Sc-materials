// hash.h
//
//  SOLUTION FOR ADT HASH QUESTION
//

#ifndef HASH_H
#define HASH_H

#include "list.h"

typedef int (*HashFunction)(PKey);


Result Create    (HT** ppHash, int size, CompFunction comp_f, 
			      KeyFunction key_f,HashFunction hash_f);

void   Destroy   (HT*   pHash);
Result Insert    (HT*   pHash, PData pdata);
PData  Find      (HT*   pHash, PKey  pkey);
PData  Remove    (HT*   pHash, PKey  pkey);


#endif

/////////////////////////////////////////
// B:

struct tagHashTable 
{
	PList* ListArray;
	int    size;
	HashFunction hash_f;
};


// C:

PData  Find      (HT*   pHash, PKey  pkey)
{
	int which = pHash->hash_f(pkey);
	PList plist =  pHash->ListArray[which];
	return ListFind(plist, pkey);
}


// D:

int StrHash (PData p)
{
	int iRet = 0;
	char* str = p;
	if (str[0])
	{
	     iRet += str[0] - 'A';
		 if (str[1])
			 iRet +=str[1] - 'A';
	}

	return iRet;
}

