#include <stdio.h>
#include <unistd.h>

int main() {

    int pid, x[2];
    char instring[20];

    // initialise pipe
    pipe(x);

    pid = fork();

    // child sends message to parent
    if(pid == 0) {
        // write 7 character to the write end of pipe
        write(x[1], "Hi Mom!", 7);
    
    // parent receives message from child
    } else {
        // read from the pip
        read(x[0], instring, 7);
        printf("%s", instring);
    }

    return 0;
}
