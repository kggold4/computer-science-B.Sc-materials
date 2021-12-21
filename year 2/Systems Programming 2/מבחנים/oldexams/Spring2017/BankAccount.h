#ifndef BANKACCOUNT_H_
#define BANKACCOUNT_H_

#include <iostream>
using namespace std;

#include <vector>
#include <algorithm>

class BankAccount {
public:
	BankAccount(int id = -1, double balance = 0) :
			id_(id), balance_(balance) {
	}
	;
	virtual BankAccount& operator+=(double sum) = 0;
	virtual void print(ostream& ro) const = 0;
	friend class compare_accounts;
protected:
	int id_;
	double balance_;
};

ostream& operator<<(ostream& ro, const BankAccount& acc) {
	acc.print(ro);
	return ro;
}

class HomeAccount: public BankAccount {
public:
	HomeAccount(int id = -1, double balance = 0) :
			BankAccount(id, balance) {
	}
	;
	BankAccount& operator+=(double sum) {
		this->balance_ += sum;
		return *this;
	}
	virtual void print(ostream& ro) const {
		ro << "id: " << id_ << " , balance: " << balance_;
	}
};

class ForeignAccount: public BankAccount {
public:
	ForeignAccount(double exchangeRate, int id = -1, double balance = 0) :
			BankAccount(id, balance), exchangeRate_(exchangeRate) {
	}
	;
	BankAccount& operator+=(double sum) {
		this->balance_ += sum * exchangeRate_;
		return *this;
	}
	virtual void print(ostream& ro) const {
		ro << "id: " << id_ << " , balance: " << balance_
				<< " , ex rate: " << exchangeRate_;
	}
private:
	double exchangeRate_;
};

class compare_accounts {
public:
	bool operator()(BankAccount* a, BankAccount* b) {
		return (a->balance_ < b->balance_);
	}
	;
};

class Bank {
public:
	void addAccount(BankAccount* acc) {
		accounts.push_back(acc);
	}

	void printAccounts() {
		sort(accounts.begin(), accounts.end(), ca);
		for (vector<BankAccount*>::iterator it = accounts.begin();
				it != accounts.end(); ++it) {
			cout << *(*it) << endl;
		}
	}
private:
	vector<BankAccount*> accounts;
	compare_accounts ca;
};



#endif /* BANKACCOUNT_H_ */
