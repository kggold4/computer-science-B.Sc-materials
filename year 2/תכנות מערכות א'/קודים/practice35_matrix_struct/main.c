#include <stdio.h>
#include <stdlib.h>

typedef struct matrix {
    int row, col;
    int *arr2d;
} matrix;

matrix * init(int row, int col) {

    int * arr = (int*)malloc(sizeof(int)*row*col);
    if(!arr) {
        return NULL;
    }
    for(int i = 0; i < row*col; i++) {
        arr[i] = 0;
    }

    matrix * m = (matrix*)malloc(sizeof(matrix));
    m -> arr2d = arr;
    m -> col = col;
    m -> row = row;

    return m;
}

void set(matrix* mat, int twoDarr[][3]){
    for(int i = 0; i < mat -> row; i++) {
        for(int j=0; j < mat -> col; j++) {
            *(mat -> arr2d + (i * mat -> col + j)) = twoDarr[i][j];
        }
    }
}

void printMatrix(matrix* mat){
    for(int i =0 ; i < mat -> row * mat -> col; i++){
        if(!(i % mat -> col)) {
            printf("\n");
        }
        printf("%d, ",*(mat -> arr2d + i));
    }
    printf("\n");
}


int main(void) {
    matrix * a = init(3,3);
    printMatrix(a);
    int arr[3][3] = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}};
    set(a, arr);
    printMatrix(a);
    
    return 0;
}