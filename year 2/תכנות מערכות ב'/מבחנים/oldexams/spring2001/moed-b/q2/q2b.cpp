#include <stdio.h>

char b[] = "((6-1)-(1+2))";
int i = 0;

typedef  enum _TYPE { ADD, SUB, NUM } TYPE;

struct NODE
{
    NODE(int v, TYPE type, NODE* p1 = 0, NODE* p2 = 0) : val(v), t(type), pArg1(p1), pArg2(p2) {}
	int val;
	TYPE t;

	NODE* pArg1;
	NODE* pArg2;
};


int calc()
{
	int x, y;
	char op;

	if (b[i] == '/0') return 0;
	if (b[i] == '(')
	{
		i++;
		x = calc();
		op = b[i++];
		y = calc();
		i++;
		return (op == '+') ? x+y : x-y;
	}
	return (b[i++] - '0');
}

int calc(NODE* p)
{
	if (!p) return NULL;

	switch (p->t)
{
	case ADD:
		return calc(p->pArg1) + calc(p->pArg2);
	case SUB:
		return calc(p->pArg1) - calc(p->pArg2);
	default:
		;
	}
	return p->val;
}

void main()
{
    int i = calc();
    printf("%d\n", i);

    NODE* p = new NODE(0, SUB);
    p->pArg1 = new NODE(2, NUM);
    p->pArg2 = new NODE(0, ADD);
    p->pArg2->pArg1 = new NODE(5, NUM);
    p->pArg2->pArg2 = new NODE(3, NUM);
    i = calc(p);
    printf("%d\n", i);
}