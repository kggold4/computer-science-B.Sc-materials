#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>

int
main(int argc, char *argv[])
{
	DIR		*dp;
	struct dirent	*dirp;

	if (argc != 2) {
		printf("usage: list directory_name\n");
		exit(1);
	}

	if ((dp = opendir(argv[1])) == NULL) {
		printf("can't open %s", argv[1]);
		exit(1);
	}
	while ((dirp = readdir(dp)) != NULL) {
		if (strcmp(dirp->d_name, ".") == 0 || strcmp(dirp->d_name, "..") == 0)
			continue;
		printf("%lu\t", dirp->d_ino);
		printf("%s\n", dirp->d_name);
        }

	closedir(dp);
}
