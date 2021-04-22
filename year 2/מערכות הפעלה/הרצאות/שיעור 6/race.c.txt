/*
Robert Iakobashvili, MIT, Apache or BSD license - whatever you wish.

Compile as: gcc -g race.c -o race -lpthread
Objdump it as: objdump -d -S race

1. Play by commenting out and returning back call to bindToCpu.
2. Play by using either ++ or atomic operations.

Run it as ./race
*/
#define _GNU_SOURCE

#include <stdio.h>     
#include <sched.h>
#include <pthread.h>
#include <errno.h>

#define CYCLESNUM 10000000

void* thrFunc(void *arg);

int bindToCPU();

int gVal = 0;

int main()
{
    int stackVal = 0;
    pthread_t firstThrId;
    pthread_t secondThrId;

    int rval = pthread_create(&firstThrId, NULL, thrFunc, (void*)&stackVal);

    rval = pthread_create(&secondThrId, NULL, thrFunc, (void*)&stackVal);


    rval = pthread_join(firstThrId, NULL);
    rval = pthread_join(secondThrId, NULL);

    printf("gVal = %d, stackVal = %d\n", gVal, stackVal);

    return 0;
}

void* thrFunc(void *arg)
{
    //bindToCPU();

    for (int k = 0; k < CYCLESNUM; k++)
    {
        *((int*)arg) += 1;

        //__atomic_add_fetch (&gVal, 1,__ATOMIC_SEQ_CST);
        gVal++;
    }
    return NULL;
}

int bindToCPU()
{
    //we can set one or more bits here, each one representing a single CPU
    cpu_set_t cpuset;

    //the CPU we whant to use
    int cpu = 1;

    CPU_ZERO(&cpuset);       //clears the cpuset
    CPU_SET(cpu , &cpuset); //set CPU 1 on cpuset

    // Different Linux implementations could use either type of the affinity API

    //pthread_t current_thread = pthread_self();
    //pthread_setaffinity_np(current_thread, sizeof(cpu_set_t), &cpuset);

    if (sched_setaffinity(0, sizeof(cpuset), &cpuset) == -1)
    {
        fprintf(stderr, "sched_setaffinity - error with errno %d\n", errno);
        return -1;
    }
    return 0;
}
