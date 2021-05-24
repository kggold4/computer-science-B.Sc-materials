#include "BankAccount.h"

int main(int argc, char **argv) {
	BankAccount** arr = new BankAccount*[3];

	// NIS - home currency account
	// id: 123456789, balance: 0, no exchange rate
	HomeAccount NIS(123456789);

	// USD - foreign currency account
	// id: 123456789, balance: 0, exchange rate: 0.27
	ForeignAccount USD(0.27, 123456789);

	// EUR - foreign currency account
	// id: 987654321, balance: 100, exchange rate: 0.26
	ForeignAccount EUR(0.26, 987654321, 100);

	arr[0] = &NIS;
	arr[1] = &USD;
	arr[2] = &EUR;

	for (int i = 0; i < 3; i++) {
		cout << "Account " << i << " - " << *arr[i] << endl;
		*arr[i] += 1; // adding 1 NIS to the account
		cout << "Account " << i << " - " << *arr[i] << endl;
	}

	Bank bank;
	bank.addAccount(&EUR);
	bank.addAccount(&USD);
	bank.addAccount(&NIS);
	bank.printAccounts();

	return 0;
}

