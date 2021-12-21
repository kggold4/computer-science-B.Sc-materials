#ifndef __SET_H__
#define __SET_H__

typedef enum _BOOL { FALSE=0, TRUE=1 } BOOL;

typedef struct Set* PSet;

typedef BOOL(*Char_pred)(char);

typedef void(*Char_func)(char);

PSet Create(PSet another);

void Destroy(PSet set);

int Get_Size(PSet set);

BOOL Add(PSet set, char C);

BOOL Remove(PSet set, char C);

void Init(PSet set, Char_pred pred);

BOOL on_each(PSet set, Char_func func);

#endif