#This makefile was generated automatically by MakeMake

#Definitions

CC=g++
CFLAGS=-g -Wall
CCLINK=g++
LIBS=
OBJS=Tree.o q3.o Plant.o Flower.o Bush.o 
RM=rm -f

#Target

Q3: $(OBJS)
	  $(CCLINK) -o Q3 $(OBJS) $(LIBS)

#Dependencies

Bush.o: Bush.cpp Bush.h Plant.h
Flower.o: Flower.cpp Flower.h Plant.h
Plant.o: Plant.cpp Plant.h
q3.o: q3.cpp Tree.h Plant.h Flower.h
Tree.o: Tree.cpp Tree.h Plant.h

#Clean

clean:
	  $(RM) Q3 *.o *.bak *~ "#"* core
