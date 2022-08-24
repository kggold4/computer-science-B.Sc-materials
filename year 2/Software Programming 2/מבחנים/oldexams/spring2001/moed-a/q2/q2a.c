#include <stdio.h>
#include <stdlib.h>
#include <memory.h>


typedef enum _BOOL
{
    FALSE,
    TRUE
} BOOL;

typedef struct _TRIE
{
    struct _TRIE* Arr[26];
    BOOL f;
} TRIE, *PTRIE;

void
Insert(PTRIE p, char* sz)
{
    int i;

    for (; *sz; sz++)
    {
        i = *sz - 'a';

        if ( !(p->Arr[i]) )
        {
            if ( !(p->Arr[i] = (PTRIE) malloc(sizeof(TRIE))) )
            {
                exit(-1);
            }
            memset(p->Arr[i], 0, sizeof(TRIE));
        }

        p = p->Arr[i];
    }
    p->f = TRUE;
}

void
Sort(PTRIE p, char* sz, int iIndex)
{
    int i;

    if (p->f)
    {
        printf("%s\n", sz);
    }

    for (i = 0; i < 26; i++)
    {
        if (p->Arr[i])
        {
            sz[iIndex] = (char) ('a' + i);
            Sort(p->Arr[i], sz, iIndex + 1);
        }
    }
    sz[iIndex] = 0;
}

void main()
{
    TRIE Root;
    char szBuf[100];

    memset(&Root, 0, sizeof(TRIE));
    memset(szBuf, 0, sizeof(szBuf));

    Insert(&Root, "bbbb");
    Insert(&Root, "abc");
    Insert(&Root, "ac");
    Insert(&Root, "a");

    *szBuf = 0;
    Sort(&Root, szBuf, 0);
}
