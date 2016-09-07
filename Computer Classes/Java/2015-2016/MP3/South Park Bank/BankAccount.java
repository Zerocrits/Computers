//Bill Joseph
//BankAccount
//Class that models a simple bank account

public class BankAccount
{
	private String name;
	private double balance;
	private int accountNumber;
	private static int nextNumber = 1;

	/** Default Constructor - Default values for our Instance Variables
	*	sets the accountNumber using nextNumber
	*	nextNumber gets incremented
	*/
	public BankAccount()
	{
		name = "";
		balance = 0.0;
		accountNumber = nextNumber;
		nextNumber = nextNumber + 1;
	}

	/** Overloaded Constructor
	*	allows account holder name to be set
	*	sets the accountNumber using nextNumber
	*	nextNumber gets incremented
	*/
	public BankAccount(String accountHolder)
	{
		name = accountHolder;
		balance = 0.0;
		accountNumber = nextNumber;
		nextNumber = nextNumber + 1;
	}

	public String getName()
	{
		return name;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public double getBalance()
	{
		return balance;
	}

	/** Adds an amount to the balance on this account */
	public void deposit(double amount)
	{
		balance = balance + amount;
	}

	/** Withdraws an amount from the balance on this account
	*	only if the account has sufficient funds for the withdrawl */
	public void withdraw(double amount)
	{
		balance = balance - amount;
	}
}
