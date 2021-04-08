#include "ecnript.h"
#include <stdio.h>

int main()
{

	int c = 0;

	while (c < 49 || c > 51){
		printf( "\n 1 - Michal The Musician: ");
		printf( "\n 2 - Hilel The Tolmid Hoham: ");
		printf( "\n 3 - Merav The Engeneer: ");
		printf( "\n Select an agent :");
		c = getchar( );
	}


	char *name;
	long id;

	if (c == 49){
		name = "Michal";
		id = 22446688;
	}

	if (c == 51){
		name = "Merav";
		id = 11223344;
	}

	if (c == 50){
		name = "Hilel";
		id = 11335577;
	}

	int type = getType(name);

	if (type != 0)
	{
		*((char*)-1) = 'x';
	}

	printf("starting encription\n");
	char* ecripted = getEncriptedMessage(name,type,id);
	printf("\nencription done:\n");
	printf("%s\n",ecripted);
	printf("****------------------------------------------****\n");
	printf("| Put the above in read.me, and upload to moodle |\n");
	printf("****------------------------------------------****\n");
	return 0;
}
