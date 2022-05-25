#include <unistd.h>
#include <stdio.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <sys/wait.h>

int
main(int argc, char *argv[])
{
    int pfd[2];                                     /* Pipe file descriptors */

    if (pipe(pfd) == -1) {                          /* Create pipe */
        perror("pipe");
	exit(1);
    }

    switch (fork()) {
    case -1:
    {
        perror("fork");
	exit(1);
    }

    case 0:             /* First child: exec 'ls' to write to pipe */
        if (close(pfd[0]) == -1) {                  /* Read end is unused */
            perror("close 1");
	    exit(1);
        }

        /* Duplicate stdout on write end of pipe; close duplicated descriptor */

        if (pfd[1] != STDOUT_FILENO) {              /* Defensive check */
            if (dup2(pfd[1], STDOUT_FILENO) == -1) {
                perror("dup2 1");
	        exit(1);
            }
            if (close(pfd[1]) == -1) {
                perror("close 2");
	        exit(1);
            }
        }

        execlp("ls", "ls", (char *) NULL);          /* Writes to pipe */
        perror("execlp ls");
	exit(1);

    default:            /* Parent falls through to create next child */
        break;
    }

    switch (fork()) {
    case -1:
    {
        perror("fork");
	exit(1);
    }

    case 0:             /* Second child: exec 'wc' to read from pipe */
        if (close(pfd[1]) == -1) {                    /* Write end is unused */
            perror("close 3");
	    exit(1);
        }

        /* Duplicate stdin on read end of pipe; close duplicated descriptor */

        if (pfd[0] != STDIN_FILENO) {               /* Defensive check */
            if (dup2(pfd[0], STDIN_FILENO) == -1) {
                perror("dup2 2");
	        exit(1);
            }
            if (close(pfd[0]) == -1) {
                perror("close 4");
	        exit(1);
            }
        }

        execlp("wc", "wc", "-l", (char *) NULL);
        perror("execlp wc");
	exit(1);

    default: /* Parent falls through */
        break;
    }

    /* Parent closes unused file descriptors for pipe, and waits for children */

    close(pfd[0]);
    close(pfd[1]);
    wait(NULL);
    wait(NULL);

    exit(EXIT_SUCCESS);
}
