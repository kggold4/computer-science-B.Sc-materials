#include <stdio.h>
#include <stdlib.h>

int main()
{

    __pid_t pid = fork();

    printf("pid: %d\n", pid);

    if (pid == 0)
    {
        printf("called by child\n");
    }
    else
    {
        printf("called by parent\n");
    }

    __pid_t child = getpid();
    printf("child pid: %d\n", pid);

    __pid_t parent = getppid();
    printf("parent pid: %d\n", pid);

    return 0;
}
