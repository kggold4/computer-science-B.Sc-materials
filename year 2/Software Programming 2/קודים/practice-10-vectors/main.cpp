#include <iostream>
#include <vector>

using namespace std;

void print_vector(std::vector<int> mat) {
    cout << "size is: " << mat.size() << endl;
    cout << "vector is: ";
    for(int i = 0; i < mat.size(); i++) {
        cout << mat[i];
        if(i != mat.size() - 1) {
            cout << ", ";
        }
    }
    cout << endl;
}

int main() {

    std::vector<int> mat;

    // push elements
    mat.push_back(2);
    mat.push_back(6);
    mat.push_back(5);
    mat.push_back(9);
    mat.push_back(3);

    print_vector(mat);

    // delete last element
    mat.pop_back();

    // delete the third element (by index)
    mat.erase(mat.begin() + 3);

    print_vector(mat);

    return 0;
}
