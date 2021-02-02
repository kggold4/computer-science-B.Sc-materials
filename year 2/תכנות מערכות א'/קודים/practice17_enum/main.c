#include <stdio.h>

enum week {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};


int main(void) {

    enum week today;
    today = WEDNESDAY;
    printf("Day %d", today + 1);
    
    return 0;
}
