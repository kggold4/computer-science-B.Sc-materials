#include <stdio.h>

int main(void) {

    int account;
    char name[30];
    double balance;

    FILE * cfPtr;

    if((cfPtr = fopen("account.txt", "w")) == NULL) {
        printf("file cannot be open");
        return 1;
    } else {
        printf("enter the account, name and balace:\n>>");
        scanf("%d%s%lf", &account, name, &balance);
        // write account, name and balance into file with fprintf
        while(!feof(stdin)) {
            fprintf(cfPtr, "%d %s %.2f\n", account, name, balance);
            printf(">>");
            scanf("%d%s%lf", &account, name, &balance);
        }
        fclose(cfPtr);
    }

    return 0;
}
