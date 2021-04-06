#include <stdio.h>
#include <stdlib.h>

int main() {

    int i = 1;
    printf("my process pid is %d\n", getpid());

    __pid_t fork_id = fork();

    if(fork_id == -1) {
        perror("cannot fork\n");
        exit(EXIT_FAILURE);
    } else if(fork_id == 0) {
        i = 7;
        printf("child pid %d, i = %d\n", getpid(), i);
    } else {
        printf("parent pid %d, i = %d\n", getpid(), i);
    }

    return 0;
}
