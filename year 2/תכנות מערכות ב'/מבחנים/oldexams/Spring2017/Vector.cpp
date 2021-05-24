#include "Vector.h"

#include <iostream>
using namespace std;

int main(int argc, char **argv) {

	SafeVec<int> vec(3);

	cout << "vec[0] - " << vec[0] << endl;
	cout << "vec[1] - " << vec[1] << endl;
	cout << "vec[2] - " << vec[2] << endl;

	try {
		cout << vec[3] << endl;
	} catch (SafeVecException& e) {
		cout << "SafeVecException" << endl;
	}

	vec[0] = 10;
	vec[1] = 11;
	vec[2] = 12;

	for(SafeVec<int>::SafeIterator iter = vec.begin(); iter != vec.end(); ++iter){
		cout << (*iter) << endl;
	}


	const SafeVec<char> vecChar(3);

	cout << "vecChar[0] - " << vecChar[0] << endl;
	cout << "vecChar[1] - " << vecChar[1] << endl;
	cout << "vecChar[2] - " << vecChar[2] << endl;

	try {
		cout << vecChar[3] << endl;
	} catch (SafeVecException& e) {
		cout << "MyVecException" << endl;
	}


	SafeVec<int> vecInt (5);
	vecInt[0] = 5;
	SafeVec<SafeVec<int> > vecVec(3);
	vecVec[0] = vecInt;
	cout << "a. " << vecVec[0].operator [](0) << endl;
	vecVec[0].operator [](0) = 6;
	cout << "b. " << vecVec[0].operator [](0) << endl;
	cout << "c. " << vecInt[0] << endl;




	return 0;

}

