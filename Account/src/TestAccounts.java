
public class TestAccounts {

	public static void main(String[] args) 
	{
		Account account = new Account(6000);
		System.out.println("*** Kim's account ***");
		account.printBalance();
		account.credit(5000);
		account.debit(2000);
		account.printBalance();
		SavingsAccount save = new SavingsAccount(2000);
		System.out.println("*** Mike's savings account ***");
		System.out.println("Mike has $" + save.getBalance());
		save.CalculateInterest(.3);
		save.credit(200);//adds the interest when depositing
		save.printBalance(); //interest added automatically.. could be coded better but works
		CheckingsAccount check = new CheckingsAccount(5000);
		System.out.println("*** Sara's checkings account ***");
		System.out.println("Sara has $" + check.getBalance());
		check.setFee(100);
		check.credit(2000);//-100
		check.debit(350);//+100+100 = 200... 5000 + (2000 - 100) = 6900 - (350 + -100) = 6450
		check.printBalance(); //fee is added automatically.. could be coded better but works
		System.out.println("Checking for negative accounts...");
		System.out.println("*** Tim's savings account ***");
		CheckingsAccount negaccount = new CheckingsAccount(-5000);
		negaccount.printBalance();
		System.out.println("*** A checkings account ***");
		SavingsAccount negaccount2 = new SavingsAccount(100);
		negaccount2.printBalance();//interest still 600 from the static variable
		negaccount2.debit(5000);
	}

}
