/*********************************
*
* FILE: conn.h
*
* The connection interface
* MAMAT exam adtq solution 
*
**********************************/

typedef enum _BOOL { FALSE, TRUE } BOOL;
typedef void* PElem;

typedef PElem (*cpy_fun)(PElem);

typedef struct conn Conn, *PConn;

PConn   ConnCreate (int iToPid, cpy_fun cpy);
PElem   ConnRead   (PConn);
BOOL    ConnWrite  (PConn,PElem);
void    ConnClose  (PConn);