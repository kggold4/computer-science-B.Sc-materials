# variables
CC = gcc
WGC = -Wall -g -c

# main command
all: main

main: main.o
	$(CC) -Wall  main.o -o main

main.o: main.c
	$(CC) $(WGC) main.c


.PHONY: clean all

# removing all .o, .out, main (exeute) file
clean:
	rm -f *.o *.out *.a *.so *.gch main