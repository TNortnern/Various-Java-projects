
public class CheckingsAccount extends Account
{
	static double fee;
	
	public CheckingsAccount(double balance) 
	{
		super(balance);
		
		
	}
	
	public void setFee(double fee) 
	{
		CheckingsAccount.fee = fee;
	}
	
	@Override
	public void debit(double debit) 
	{
		if (completed == true) 
		{
		debit+=fee;
		}
		super.debit(debit);
		
		
	}
	
	@Override
	public void credit(double credit) 
	{
		if (completed == true) 
		{
		credit-=fee;
		}
		super.credit(credit);
	}
	
	@Override
	public void printBalance() 
	{
		if (completed == true) 
		{
		System.out.println("The fee for each transaction will be $" + fee);
		super.printBalance();
		}
	}
}
