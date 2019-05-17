
public class Account 
{
	private double balance;
	boolean completed = true;
	
	public Account(double balance) 
	{
		this.balance = balance;
		if (balance < 0)
		{
			System.out.println("Insufficient funds!");
		}
		
		
	}
	
	public void debit(double debit) 
	{
		System.out.println("Withdrawing..$" + debit);
		if (debit <= balance) 
		{
			balance -= debit;
			completed = true;
		}
		else 
		{
			completed = false;
			System.out.println("$" + debit + " exceeds your balance!");
		}
	}
	
	public void credit(double credit) 
	{
		System.out.println("Depositing...$" + credit);
		balance += credit;
	}
	
	public double getBalance() 
	{
		return balance;
	}
	
	public void printBalance() 
	{
		if (balance >= 0) 
		{
		System.out.println("Your balance is: $" + balance);
		}
		else 
		{
			System.out.println("You are in debt!");
		}

	}
}
