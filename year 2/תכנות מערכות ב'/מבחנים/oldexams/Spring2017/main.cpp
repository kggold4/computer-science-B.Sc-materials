#include "FamilyMember.h"
#include <iostream>
using namespace std;

int main() {
	cout << "Number of family members: " << FamilyMember::getNumOfMembers() << endl;
	FamilyMember::setFamilyName("Smith");
	const char* name = "Alice";
	FamilyMember Alice(name);
	name = "Bob";
	FamilyMember Bob(name);
	FamilyMember* Charlie = new FamilyMember("Charlie");
	cout <<  "Number of family members: " << (*Charlie).getNumOfMembers() << endl;
	cout << Alice.getName() << " " << Alice.getFamilyName() << endl;
	FamilyMember arr[3];
	cout <<  "Number of family members: " << FamilyMember::getNumOfMembers() << endl;
	arr[0] = Alice;
	arr[1] = Bob;
	arr[2] = (*Charlie);
	cout << arr[2].getName() << " " << arr[2].getFamilyName() << endl;
	delete Charlie;
	cout << arr[2].getName() << " " << arr[2].getFamilyName() << endl;
	cout <<  "Number of family members: " << FamilyMember::getNumOfMembers() << endl;
	FamilyMember BobJunior(Bob);
	cout << BobJunior.getName() << " " << BobJunior.getFamilyName() << endl;
	return 0;
}

