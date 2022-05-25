#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main() {


	char *args[4];
	args[0] = "ls";
	args[1] = "-l";
	args[2] = "a.out";
	args[3] = NULL;

	execvp(args[0], args);
}

