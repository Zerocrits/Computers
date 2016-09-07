//Bill Joseph
//AcountRunner
//Main class that demonstrates polymorphism using bank accounts.

import java.util.ArrayList;

public class AccountRunner
{
	public static void main(String[] args)
	{
		SavingsAccount collegeFund = new SavingsAccount("Luke",2.67);
		SavingsAccount carMoney = new SavingsAccount("Luke",1.8);
		CheckingAccount living = new CheckingAccount("Dad");
		ArrayList<BankAccount> finances = new ArrayList<BankAccount>();
		finances.add(collegeFund);
		finances.add(carMoney);
		finances.add(living);

		collegeFund.deposit(250.0);
		carMoney.deposit(100.0);
		living.deposit(400.0);
		living.withdraw(49.99);
		living.withdraw(21.40);
		living.withdraw(89.90);

		addToAll(finances, 5.0);
		showAll(finances);
		collegeFund.addInterest();
		carMoney.addInterest();
		living.deductFees();
		showAll(finances);
		System.out.println();
	}

	/** Adds the same 'amount' to each of the accounts in 'accounts' */
	private static void addToAll(ArrayList<BankAccount> accounts, double amount)
	{
		for(int i = 0; i < accounts.size(); i++)
		{
			accounts.get(i).deposit(amount);
		}
	}

	/** Neatly displays The Account Holder, Account Number and Balance for each of the accounts in 'accounts' */
	private static void showAll(ArrayList<BankAccount> accounts)
	{
		System.out.println("Account Holder\t\t\tAccount Number\t\t\tBalance");
		for(int i = 0; i < accounts.size(); i++)
		{
			System.out.println(accounts.get(i).getName() + "\t\t\t\t\t" + accounts.get(i).getAccountNumber() + "\t\t\t$" + accounts.get(i).getBalance());
		}
	}
}
/*

Account Holder                  Account Number                  Balance
Luke                                    1                       $255.0
Luke                                    2                       $105.0
Dad                                     3                       $243.71
Account Holder                  Account Number                  Balance
Luke                                    1                       $935.85
Luke                                    2                       $294.0
Dad                                     3                       $243.71

Press any key to continue . . .

*/
