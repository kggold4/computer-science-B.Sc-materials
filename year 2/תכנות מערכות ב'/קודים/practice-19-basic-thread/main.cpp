// includes
#include <iostream>
#include <thread>
#include <chrono>

using namespace std;

// point class
class Point {
    private:
        int x;
        int y;
    public:
        Point() { x = y = 5555; }
};

int main() {

    const int KB = 1024;
    const int SIZE = 50 * 1000 * KB;

    cout << "before new" << endl;
    this_thread::sleep_for(chrono::seconds(3));

    Point * p = new Point[SIZE];
    for(int i = 0; i < SIZE; i++) {
        p[i] = Point();
    }

    cout << "after new" << endl;

    this_thread::sleep_for(chrono::seconds(10));

    delete[] p;

    return 0;
}
