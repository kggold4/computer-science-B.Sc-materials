#!make -f

CXX=clang++-9
CXXFLAGS=-std=c++2a

OBJECTS=Node.o LinkedList.o
SOURCES=Node.cpp LinkedList.cpp

run: main

main: main.o $(OBJECTS)
	$(CXX) $(CXXFLAGS) $^ -o main

%.o: %.cpp $(HEADERS)
	$(CXX) $(CXXFLAGS) --compile $< -o $@

clean:
	rm -f *.o main
