#include <stdio.h>
#include <stdlib.h>

typedef struct student {
    char name[30];
    int roll;
    float perc;
} student;

int main() {
    
    student *pstd;
    pstd = (student*)malloc(sizeof(student)*1);

    if(pstd == NULL) {
        return 1;
    }

    printf("Enter name: ");
    fgets(pstd->name);

    printf("Enter roll number: ");
    scanf("%d",&pstd->roll);
    
    printf("Enter percentage: ");
    scanf("%f",&pstd->perc);


    printf("name: %s, roll number: %d, percentage: %.2f\n", pstd -> name, pstd -> roll, pstd -> perc);

    free(pstd);
    return 0;
}
