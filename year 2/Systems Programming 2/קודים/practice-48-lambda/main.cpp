#include <iostream>
#include <vector>

using namespace std;

pair<vector<int>, vector<int>> split_vectors(const vector<int> values, bool(*func)(int)) {
    vector<int> positive;
    vector<int> negative;
    for(int value : values) {
        if(func(value)) { positive.push_back(value); }
        else { negative.push_back(value); }
    }
    return make_pair(positive, negative);
}

void print_vector(vector<int>& values) {
    auto it = values.begin();
    cout << "list: ";
    while(it != values.end()) {
        cout << *it << ' ';
        ++it;
    }
    cout << endl;
}

int main() {

    vector<int> values = { 5, 6, -2, 0, 3, 6, -1, -3, 4, 2, 7 };
    auto lambda = [](int value) { return value >= 0; };
    auto p = split_vectors(values, lambda);
    print_vector(p.first);
    print_vector(p.second);
    return 0;
}
