#include <unistd.h>
#include <stdio.h>

int * getNum() {
    return (int*)22;
}

void print(int * val) {
    printf("val = %d\n", *val);
}

void printLong() {
    int i;
    for(i = 0; i < 200; i++) {
        printf("Hello Number %d\n", i);
        usleep(1000000);
    }
}

int main() {
    printf("pid: %ld ,ppid: %ld\n", (long)getpid(), (long)getppid());
    // print(getNum());
    printLong();
    return 0;
}
