//Bill Joseph
//SavingsAccount
//Class that extends BankAccount to model a savings account.

public class SavingsAccount extends BankAccount
{
	private double interestRate;

	/** Constructor - Sets the rate of interest for this Savings Account */
	public SavingsAccount(double rate)
	{
		interestRate = rate;
	}

	/** Constructor - Sets the name and interest rate for this Savings Account */
	public SavingsAccount(String accountHolder, double rate)
	{
		super(accountHolder);
		interestRate = rate;
	}

	/** Calculates interest at the given rate and adds it to this Savings Account */
	public void addInterest()
	{
		double balance = super.getBalance();
		super.deposit(balance*interestRate);
	}
}
