#include <stdio.h>

typedef struct Point {
    int x, y;
} Point;

int main() {
    Point p1 = {
        .x = 13,
        .y = -5
    };
    //Point p2;

    //FILE* in;
    //FILE* out;

    fopen("point.bin", "wb");
    // if(out == NULL) {
    //     return 1;
    // }

    size_t elements_written = fwrite(&p1, sizeof(Point), 1);
    //fclose(out);
    if(elements_written == 0) {
        return 2;
    }




    return 0;
}
