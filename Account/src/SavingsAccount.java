
public class SavingsAccount extends Account
{
	static double interest;
	
	public SavingsAccount(double balance) 
	{
		super(balance);
	}
	
	public double CalculateInterest(double interest) 
	{
		SavingsAccount.interest = interest * getBalance();
		return interest;
	}
	
	@Override
	public void credit(double credit) 
	{
		completed = true;// just a placeholder
		credit+=interest;
		super.credit(credit);
	}

	
	@Override
	public void printBalance() 
	{
		if (completed == true) 
		{
		System.out.println("The interest rate will be $" + interest);
		super.printBalance();
		
		}
		
		
	}
}
