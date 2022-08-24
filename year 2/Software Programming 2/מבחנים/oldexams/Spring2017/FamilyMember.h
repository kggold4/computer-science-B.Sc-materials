#include <stdlib.h>
#include <string.h>

class FamilyMember {
public:
	FamilyMember() :
			name_(NULL) {
		members_++;
	}
	FamilyMember(const char* name) {
		members_++;
		if (name == NULL) {
			return;
		}
		name_ = new char[strlen(name) + 1];
		strcpy(name_, name);
	}
	FamilyMember(const FamilyMember& rhs) {
		members_++;
		if (rhs.name_ == NULL) {
			return;
		}
		name_ = new char[strlen(rhs.name_) + 1];
		strcpy(name_, rhs.name_);
	}
	FamilyMember& operator=(const FamilyMember& rhs) {
		if (this != &rhs) {
			if (name_ != NULL) {
				delete name_;
			}
			name_ = new char[strlen(rhs.name_) + 1];
			strcpy(name_, rhs.name_);
		}
		return *this;
	}
	static const int getNumOfMembers() {
		return members_;
	}
	static void setFamilyName(const char* name) {
		if (name == NULL) {
			return;
		}
		familyName_ = new char[strlen(name) + 1];
		strcpy(familyName_, name);
	}
	static const char* getFamilyName() {
		return familyName_;
	}
	const char* getName() {
		return name_;
	}
	~FamilyMember() {
		members_--;
		delete[] name_;
		if (members_ == 0) {
			delete[] familyName_;
		}
	}
private:
	static int members_;
	static char* familyName_;
	char* name_;
};
