#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

void sig_handler(int signo) {
    if(signo == SIGINT) {
        printf("received SIGINT\n Ignored :\n");
    }
    
    if(signo == SIGUSR1) {
        printf("received SIGUSR1\n doing user stuff\n");
    }
}

int main(void) {

    // print PID & PPID
    printf("pid: %ld ,ppid: %ld", (long)getpid(), (long)getppid());

    // register signal handler
    if(signal(SIGINT, sig_handler) == SIG_ERR) {
        printf("\ncan't catch SIGINT\n");
    }

    if(signal(SIGUSR1, sig_handler) == SIG_ERR) {
        printf("\ncan't catch SIGUSR1\n");
    }

    // a long long wait so that we can easily issue a signal to this process
    int counter = 0;
    while(1) {
        printf("\njust running %d\n", counter++);
        fflush(stdout);
        sleep(1);
    }

    return 0;
}
