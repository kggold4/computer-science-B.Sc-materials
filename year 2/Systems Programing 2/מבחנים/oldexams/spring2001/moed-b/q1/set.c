#include "set.h"
#include <stdlib.h>

#define CHAR_NUM (256)

struct Set {
	BOOL exist[CHAR_NUM];
	int size;
};


PSet Create(PSet another) {
	PSet set=(PSet)malloc(sizeof(struct Set));
	char i;

	if (!another) {
		for(i=0;i<CHAR_NUM;i++)
			set->exist[i]=FALSE;
		set->size=0;
	} else {
		for(i=0;i<CHAR_NUM;i++)
			set->exist[i]=another->exist[i];
		set->size=another->size;
	}

	return set;
}


void Destroy(PSet set) {
	free(set);
}


int Get_Size(PSet set) {
	return set->size;
}

BOOL Add(PSet set, char C) {
	if (set->exist[C])
		return FALSE;

	set->exist[C]=TRUE;
	set->size++;
	return TRUE;
}

BOOL Remove(PSet set, char C) {
	if (!set->exist[C])
		return FALSE;

	set->exist[C]=FALSE;
	set->size--;
	return TRUE;
}

void Init(PSet set, Char_pred pred) {
	char i;

	set->size=0;
	for (i=0;i<CHAR_NUM;i++)
		if (pred(i)) {
			set->exist[i]=TRUE;
			set->size++;
		}
}

BOOL on_each(PSet set, Char_func func) {
	char i;

	if (!set->size || !func)
		return FALSE;

	for (i=0;i<CHAR_NUM;i++)
		if (set->exist[i]) 
			func(i);

	return TRUE;
}

void print_char(char c) {
	printf("%c\n",c);
}

BOOL Print_set(PSet set) {
	return on_each(set,print_char);
}


PSet Union(PSet set1, PSet set2) {
	PSet set=(PSet)malloc(sizeof(struct Set));
	char i;

	set->size=0;

	for(i=0;i<CHAR_NUM;i++)
		if (set1->exist[i] || set2->exist[i]) {
			set->exist[i]=TRUE;
			set->size++;
		}

	return set;
}