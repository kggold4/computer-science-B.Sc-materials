CXX=clang++-9
CXXFLAGS=-std=c++2a

run: main

main: main.o
	$(CXX) $(CXXFLAGS) $^ -o main

main.o: main.cpp
	$(CXX) $(CXXFLAGS) --compile main.cpp -o main

clean:
	rm -f *.o main